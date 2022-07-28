package by.data.remoteData

import by.data.remote.User
import by.domain.coroutines.DispatcherProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class FireStore @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val dispatchers: DispatcherProvider,
) : RemoteService {

//    override suspend fun getUsersByName(s: String): Flow<List<User>> {
//        val list: MutableList<User> = ArrayList()
//        fireStore.collection("users").li
//            .whereEqualTo("name", s)
//            .get()
//            .addOnSuccessListener { task ->
//                for (document in task) {
//                    list.add(document.toObject())
//                }
//            }.await()
//        return flowOf(list)
//    }

    override suspend fun getUsersByName(s: String): Flow<List<User>> = observeFromFireStore(
        dbRef = fireStore.collection("users"),
        coroutineContext = dispatchers.io,
        keySearchQuery = "name",
        valueSearchQuery = s
    )


}