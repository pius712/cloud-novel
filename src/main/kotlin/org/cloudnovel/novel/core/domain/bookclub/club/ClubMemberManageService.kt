package org.cloudnovel.novel.core.domain.bookclub.club

import org.springframework.stereotype.Service

@Service
class ClubApplyService(
        private val clubApplicationReader: ClubApplicationReader
) {

    fun getApplicant(clubId: Long): List<ClubApplicant> {
        return clubApplicationReader.readByClub(clubId)
    }

    fun getApply(clubMemberId: Long): ClubApply {
        return clubApplicationReader.readApplication(clubMemberId)
    }

}