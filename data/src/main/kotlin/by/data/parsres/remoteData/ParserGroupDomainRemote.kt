package by.data.parsres.remoteData

import by.data.parsres.Parser
import by.data.remoteData.remoteDataBase.entities.GroupRemote
import by.data.remoteData.remoteDataBase.entities.ProfileRemote
import by.domain.entities.Group
import by.domain.entities.Profile
import javax.inject.Inject

internal class ParserGroupDomainRemote @Inject constructor(
    private val parserProfiles: Parser<Profile, ProfileRemote>,
) : Parser<Group, GroupRemote> {

    override fun pars(from: GroupRemote): Group = Group(
        userIDs = from.userIDs ?: emptyList(),
        name = from.name.orEmpty(),
        profiles = from.profiles?.map { profile -> parserProfiles.pars(profile) } ?: emptyList()
    )

    override fun unPars(from: Group): GroupRemote = GroupRemote(
        name = from.name,
        userIDs = from.userIDs,
        profiles = from.profiles.map { profile -> parserProfiles.unPars(profile) }
    )
}
