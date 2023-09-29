package org.cloudnovel.novel.core.domain.club.participant

import org.cloudnovel.novel.core.storage.club.ClubParticipantRepository
import org.cloudnovel.novel.core.storage.profile.ProfileEntity
import org.cloudnovel.novel.core.storage.profile.ProfileRepository
import org.springframework.stereotype.Component

@Component
class ClubParticipantReader(private val profileRepository: ProfileRepository,
                            private val clubParticipantRepository: ClubParticipantRepository) {


    fun readByClub(clubId: Long): List<ClubParticipant> {

        val found = clubParticipantRepository.findByClubId(clubId)
        return profileRepository.findByIdIn(found.map { it.profileId }).map(::toClubParticipant);
    }

    fun toClubParticipant(profileEntity: ProfileEntity): ClubParticipant {
        return ClubParticipant(profileEntity.id!!, profileEntity.nickname, profileEntity.nickname);
    }
}