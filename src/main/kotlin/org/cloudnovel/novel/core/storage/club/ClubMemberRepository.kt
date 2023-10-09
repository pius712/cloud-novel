package org.cloudnovel.novel.core.storage.club

import org.springframework.data.jpa.repository.JpaRepository

interface ClubMemberRepository : JpaRepository<ClubMemberEntity, Long> {

    fun findByProfileId(profileId: Long): List<ClubMemberEntity>

    fun findByClubId(clubId: Long): List<ClubMemberEntity>
    fun findByClubIdAndProfileId(clubId: Long, profileId: Long): ClubMemberEntity?
}