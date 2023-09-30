package org.cloudnovel.novel.core.domain.bookclub.club

import org.cloudnovel.novel.core.common.enum.ClubRecruitStatus
import org.springframework.stereotype.Service

/**
 * 독서 클럽 관리
 * */
@Service
class ClubManageService(
        private val clubWriter: ClubWriter,

        ) {

    fun register(profileId: Long, clubCreateRequest: ClubCreateRequest): Long {
        return clubWriter.write(profileId, clubCreateRequest)
    }

    fun openRecruitment(clubId: Long, recruitStatus: ClubRecruitStatus) {
        clubWriter.open(clubId, recruitStatus);
    }

}