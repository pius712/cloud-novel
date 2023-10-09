package org.cloudnovel.novel.core.storage.profile

import org.springframework.data.jpa.repository.JpaRepository

interface FollowerRepository : JpaRepository<FollowerEntity, Long> {
    fun findByProfileId(profileId: Long): List<FollowerEntity>
    fun countByProfileId(profileId: Long): Long

    fun deleteByProfileIdAndFollowerId(profileId: Long, followerId: Long)
    fun findByProfileIdAndFollowerId(profileId: Long, followerId: Long): FollowerEntity?
}
