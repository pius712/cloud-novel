package org.cloudnovel.novel.core.domain.bookclub.member

import org.cloudnovel.novel.core.domain.bookclub.club.Club
import org.springframework.stereotype.Service

@Service
class ClubMemberReadService(private val clubMemberReader: ClubMemberReader) {

    fun getClubMembers(clubId: Long): List<ClubMemberProfile> {
        return clubMemberReader.readByClubId(clubId)
    }

    fun getClubByProfile(profileId: Long): List<Club> {
        return clubMemberReader.readByProfileId(profileId)
    }

}