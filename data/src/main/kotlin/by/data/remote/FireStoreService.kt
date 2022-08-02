package by.data.remote

import by.data.remote.entities.GroupRemote
import by.data.remote.entities.ProfileRemote
import by.data.remote.entities.UserRemote
import by.data.remote.utils.observeItemFromFireStore
import by.data.remote.utils.observeItemsFromFireStore
import by.domain.coroutines.DispatcherProvider
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.tasks.asDeferred
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val USERS = "users"
private const val GROUPS = "groups"
private const val PROFILES = "profiles"
private const val GROUP_IDS = "groupIDs"
private const val USER_IDS = "userIDs"
private const val ID = "id"

internal class RemoteServiceImpl @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val dispatchers: DispatcherProvider,
) : RemoteService {

    override suspend fun getUsersByName(name: String): Flow<List<UserRemote>> =
        observeItemsFromFireStore(
            dbRef = fireStore.collection(USERS),
            coroutineContext = dispatchers.io,
            keySearchQuery = "name",
            valueSearchQuery = name
        )

    override suspend fun getProfilesFromGroup(groupID: String): Flow<List<ProfileRemote>> =
        observeItemsFromFireStore(
            fireStore.collection(GROUPS).document(groupID).collection(PROFILES),
            dispatchers.io
        )

    override suspend fun getProfileFromGroup(
        groupID: String,
        profileID: String,
    ): Flow<ProfileRemote> = observeItemFromFireStore(
        fireStore.collection(GROUPS).document(groupID).collection(PROFILES).document(profileID),
        dispatchers.io
    )

    override suspend fun getUsersByIDs(iDs: List<String>): Flow<List<UserRemote>> {
        val calls = iDs.map { id ->
            fireStore.collection(USERS).document(id).get().asDeferred()
        }.awaitAll()

        val list = arrayListOf<UserRemote>()

        calls.forEach { snapshot ->
            snapshot.toObject<UserRemote>()?.let { user -> list.add(user) }
        }

        return flowOf(list)
    }

    override suspend fun postProfileInGroup(groupID: String, profile: ProfileRemote): Unit =
        withContext(dispatchers.io) {
            fireStore.collection(GROUPS).document(groupID).collection(PROFILES)
                .add(profile).addOnSuccessListener { profile ->
                    profile.update(ID, profile.id)
                }
        }

    override suspend fun deleteProfileFromGroup(groupID: String, profileID: String) {
        fireStore.collection(GROUPS).document(groupID).collection(PROFILES).document(profileID)
            .delete()
    }

    override suspend fun createUser(user: UserRemote): Unit = withContext(dispatchers.io) {
        fireStore.collection(USERS).add(user).addOnSuccessListener {
            it.update(ID, it.id)
        }
    }

    override suspend fun createGroup(userID: String, group: GroupRemote) : Unit = withContext(dispatchers.io) {
        fireStore.collection(GROUPS).add(group).addOnSuccessListener {
            it.update(ID, it.id)
            it.update(USER_IDS, FieldValue.arrayUnion(userID))
        }
    }

    override suspend fun addUserInGroup(groupID: String, userID: String): Unit =
        withContext(dispatchers.io) {
            val group = fireStore.collection(GROUPS).document(groupID)

            group.update(USER_IDS, FieldValue.arrayUnion(userID)).addOnSuccessListener {
                fireStore.collection(USERS).document(userID)
                    .update(GROUP_IDS, FieldValue.arrayUnion(groupID))
            }
        }

    override suspend fun deleteUserFromGroup(groupID: String, userID: String): Unit =
        withContext(dispatchers.io) {
            fireStore.collection(GROUPS).document(groupID).update(
                USER_IDS, FieldValue.arrayRemove(userID)
            )
            fireStore.collection(USERS).document(userID).update(
                GROUP_IDS, FieldValue.arrayRemove(groupID)
            )
        }

}
