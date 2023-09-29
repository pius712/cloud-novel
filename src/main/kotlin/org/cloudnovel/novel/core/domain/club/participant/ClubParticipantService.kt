package org.cloudnovel.novel.core.domain.club.participant

import org.springframework.stereotype.Service

@Service
class ClubParticipantService(
        private val clubParticipantReader: ClubParticipantReader,
) {


    fun participants(clubId: Long): List<ClubParticipant> {
        return clubParticipantReader.readByClub(clubId)
    }


}