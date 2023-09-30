package org.cloudnovel.novel.core.domain.bookclub.club

import org.springframework.stereotype.Service

/**
 * 독서 클럽 조회
 * */
@Service
class ClubReadService(
        private val clubReader: ClubReader,
) {

    fun getClub(id: Long): Club {
        return clubReader.readById(id)
    }

    fun getClubByProfile(profileId: Long): List<Club> {
        return clubReader.readByProfile(profileId)
    }

}