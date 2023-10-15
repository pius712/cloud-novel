package org.cloudnovel.novel.core.storage.profile

import org.springframework.data.jpa.repository.JpaRepository

interface ProfileInterestRepository : JpaRepository<ProfileInterestEntity, Long> {
    fun findByProfileId(profileId: Long): List<ProfileInterestEntity>

    fun deleteAllByProfileId(profileId: Long): Unit
}