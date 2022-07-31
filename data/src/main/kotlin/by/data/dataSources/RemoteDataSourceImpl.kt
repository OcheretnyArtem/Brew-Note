package by.data.dataSources

import by.data.parsres.Parser
import by.data.remote.RemoteService
import by.data.remote.entities.UserRemote
import by.domain.dataSoures.RemoteDataSource
import by.domain.entities.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class RemoteDataSourceImpl @Inject constructor(
    private val userParser: Parser<User, UserRemote>,
    private val service: RemoteService,
) : RemoteDataSource {

    override suspend fun getUsersByName(name: String): Flow<List<User>> =
        service.getUsersByName(name).map { list ->
            list.map { user -> userParser.pars(user) }
        }
}
