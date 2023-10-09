package org.cloudnovel.novel.core.domain.profile.follow

import org.cloudnovel.novel.core.domain.profile.profile.UserProfile
import org.springframework.stereotype.Service

@Service
class FollowReadService(private val followReader: FollowReader) {


    fun getFollowingCount(profileId: Long): Long {
        return followReader.readFollowingCount(profileId)
    }

    fun getFollowing(profileId: Long): List<UserProfile> {
        return followReader.readFollowing(profileId)
    }

    fun getFollowerCount(profileId: Long): Long {
        return followReader.readFollowerCount(profileId)
    }

    fun getFollower(profileId: Long): List<UserProfile> {
        return followReader.readFollower(profileId)
    }
}