package org.cloudnovel.novel.core.domain.profile.follow

import org.cloudnovel.novel.core.domain.profile.profile.UserProfile
import org.cloudnovel.novel.core.domain.profile.profile.UserProfileReader
import org.cloudnovel.novel.core.storage.profile.FollowRepository
import org.springframework.stereotype.Component

@Component
class FollowReader(private val followRepository: FollowRepository,
                   private val userProfileReader: UserProfileReader) {


    fun readFollowing(profileId: Long): List<UserProfile> {
        val followingIds = followRepository.findByFollowerId(profileId).map { it.followingId }
        return userProfileReader.readAllById(followingIds)
    }

    fun readFollowingCount(profileId: Long): Long {
        return followRepository.countByFollowerId(profileId)
    }

    fun readFollowerCount(profileId: Long): Long {
        return followRepository.countByFollowerId(profileId)
    }

    fun readFollower(profileId: Long): List<UserProfile> {
        val followerIds = followRepository.findByFollowingId(profileId).map { it.followerId }
        return userProfileReader.readAllById(followerIds)
    }

}