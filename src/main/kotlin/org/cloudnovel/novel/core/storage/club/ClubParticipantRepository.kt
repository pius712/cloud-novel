package org.cloudnovel.novel.core.storage.club

import org.springframework.data.jpa.repository.JpaRepository

interface ClubParticipantRepository : JpaRepository<ClubParticipantEntity, Long> {

    fun findByClubId(clubId: Long): List<ClubParticipantEntity>
}