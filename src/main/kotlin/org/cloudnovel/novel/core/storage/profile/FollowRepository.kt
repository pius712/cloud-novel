package org.cloudnovel.novel.core.storage.profile

import org.springframework.data.jpa.repository.JpaRepository

interface FollowRepository : JpaRepository<FollowEntity, Long> {

    fun findByFollowerId(followerId: Long): List<FollowEntity>

    fun findByFollowingIdAndFollowerId(followingId: Long, follower: Long): List<FollowEntity>
    fun deleteByFollowerIdAndFollowingId(profileId: Long, followingId: Long): Unit

    fun countByFollowerId(profileId: Long): Long

    fun findByFollowingId(profileId: Long): List<FollowEntity>

    fun countByFollowingId(profileId: Long): Long


}