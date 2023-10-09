package org.cloudnovel.novel.core.storage.profile

import org.springframework.data.jpa.repository.JpaRepository

interface FollowingRepository : JpaRepository<FollowingEntity, Long> {
    fun findByProfileId(profileId: Long): List<FollowingEntity>
    fun deleteByProfileIdAndFollowingId(profileId: Long, followingId: Long)
}