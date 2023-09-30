package org.cloudnovel.novel.core.domain.bookclub.club

import org.springframework.stereotype.Service

@Service
class ClubApplicationService(
        private val clubApplicationReader: ClubApplicationReader
) {

    fun getApplicant(clubId: Long): List<ClubApplicant> {
        return clubApplicationReader.readByClub(clubId)
    }

    fun getApplication(clubMemberId: Long): ClubApplication {
        return clubApplicationReader.readApplication(clubMemberId)
    }

}