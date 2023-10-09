package org.cloudnovel.novel.core.domain.bookclub.club

import org.cloudnovel.novel.core.storage.club.ClubEntity
import org.cloudnovel.novel.core.storage.club.ClubRepository
import org.cloudnovel.novel.core.storage.profile.ProfileEntity
import org.cloudnovel.novel.core.storage.profile.ProfileRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ClubReader(
        private val clubRepository: ClubRepository,
        private val profileRepository: ProfileRepository,
) {
    fun readById(id: Long): Club {
        val foundClub = clubRepository.findByIdOrNull(id) ?: throw RuntimeException();
        val foundProfile = profileRepository.findByIdOrNull(foundClub.profileId) ?: throw RuntimeException()
        return toClub(foundProfile, foundClub);
    }


    fun readAllById(ids: List<Long>): List<Club> {
        val clubEntities = clubRepository.findAllById(ids);
        val foundProfiles = profileRepository.findByIdIn(clubEntities.map { it.id!! })
        val profileMap = foundProfiles.groupBy { it.id!! }
        return clubEntities.map {
            val matchedProfile = profileMap[it.profileId]?.firstOrNull()
                    ?: throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND)
            toClub(matchedProfile, it)
        }
    }

    fun readByProfile(profileId: Long): List<Club> {
        val foundProfile = profileRepository.findByIdOrNull(profileId) ?: throw RuntimeException()

        val foundClubs = clubRepository.findByProfileId(profileId)
        return foundClubs.map { toClub(foundProfile, it) }
    }

    fun toClub(profileEntity: ProfileEntity, clubEntity: ClubEntity): Club {
        return Club(
                ClubHost(profileEntity.id!!, profileEntity.nickname, profileEntity.bio),
                clubEntity.name,
                clubEntity.description,
        )
    }
}