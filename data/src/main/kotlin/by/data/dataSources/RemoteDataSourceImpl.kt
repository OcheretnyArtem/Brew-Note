package by.data.dataSources

import by.data.parsres.Parser
import by.data.remoteData.RemoteService
import by.data.remoteData.entities.ProfileRemote
import by.data.remoteData.entities.UserRemote
import by.domain.dataSoures.RemoteDataSource
import by.domain.entities.Profile
import by.domain.entities.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class RemoteDataSourceImpl @Inject constructor(
    private val userParser: Parser<User, UserRemote>,
    private val profileParser: Parser<Profile, ProfileRemote>,
    private val service: RemoteService,
) : RemoteDataSource {

    override suspend fun getUsersByName(name: String): Flow<List<User>> =
        service.getUsersByName(name).map { list ->
            list.map { user -> userParser.pars(user) }
        }

    override suspend fun postProfileInGroup(groupID: String, profile: Profile) =
        service.postProfileInGroup(groupID, profileParser.unPars(profile))

    override suspend fun deleteProfileFromGroup(groupID: String, profileID: String) =
        service.deleteProfileFromGroup(groupID, profileID)

    override suspend fun getUsersByIDs(iDs: List<String>): Flow<List<User>> =
        service.getUsersByIDs(iDs).map { list ->
            list.map { user -> userParser.pars(user) }
        }

    override suspend fun createUser(user: User) = service.createUser(userParser.unPars(user))

    override suspend fun addUserInGroup(groupID: String, userID: String) =
        service.addUserInGroup(groupID, userID)

    override suspend fun deleteUserFromGroup(groupID: String, userID: String) =
        service.deleteUserFromGroup(groupID, userID)

    override suspend fun getProfilesFromGroup(groupID: String): Flow<List<Profile>> =
        service.getProfilesFromGroup(groupID).map { list ->
            list.map { profile ->
                profileParser.pars(profile)
            }
        }

    override suspend fun getProfileFromGroup(groupID: String, profileID: String): Flow<Profile> =
        service.getProfileFromGroup(groupID, profileID).map { profile ->
            profileParser.pars(profile)
        }

}
