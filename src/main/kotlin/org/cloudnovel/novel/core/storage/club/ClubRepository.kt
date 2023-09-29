package org.cloudnovel.novel.core.storage.club

import org.springframework.data.jpa.repository.JpaRepository

interface ClubRepository : JpaRepository<ClubEntity, Long> {
    fun findByProfileId(profileId: Long): List<ClubEntity>
}