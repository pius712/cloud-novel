package org.cloudnovel.novel.core.domain.club

import org.springframework.stereotype.Service

@Service
class ClubService(
        private val clubWriter: ClubWriter
        private val
) {


    fun register(clubCreateRequest: ClubCreateRequest) {


    }

    fun openClub(surveys: List<ClubJoinSurveyRequest>) {
        clubWriter.updateStatus()

    }

    fun join(club) {

    }


}