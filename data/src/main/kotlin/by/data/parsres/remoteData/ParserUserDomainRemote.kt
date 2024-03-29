package by.data.parsres.remoteData

import by.data.parsres.Parser
import by.data.remoteData.remoteDataBase.entities.UserRemote
import by.domain.entities.User
import javax.inject.Inject

internal class ParserUserDomainRemote @Inject constructor() : Parser<User, UserRemote> {

    override fun pars(from: UserRemote): User = User(
        id = from.id,
        name = from.name.orEmpty(),
        photoURL = from.photoURL.orEmpty(),
        groupIDs = from.groupIDs ?: emptyList()
    )

    override fun unPars(from: User): UserRemote = UserRemote(
        name = from.name,
        photoURL = from.photoURL,
        groupIDs = from.groupIDs
    )
}
