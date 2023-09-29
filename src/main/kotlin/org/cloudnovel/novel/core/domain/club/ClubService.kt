package org.cloudnovel.novel.core.domain.club

import org.cloudnovel.novel.core.common.enum.ClubRecruitStatus
import org.springframework.stereotype.Service

@Service
class ClubService(
        private val clubWriter: ClubWriter,
        private val clubReader: ClubReader,
) {


    fun register(profileId: Long, clubCreateRequest: ClubCreateRequest): Long {
        return clubWriter.write(profileId, clubCreateRequest)
    }

    fun openRecruitment(id: Long, recruitStatus: ClubRecruitStatus) {
        clubWriter.open(id, recruitStatus);
    }

    fun join() {

    }

    fun getClub(id: Long): Club {
        return clubReader.readById(id)
    }

    fun getClubByProfile(profileId: Long): List<Club> {
        return clubReader.readByProfile(profileId)
    }

    fun getParticipants(clubId: Long) {

    }

}