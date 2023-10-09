package org.cloudnovel.novel.core.domain.profile.follower

import org.cloudnovel.novel.core.domain.profile.profile.UserProfile
import org.springframework.stereotype.Service

@Service
class FollowerReadService(private val followerReader: FollowerReader) {


    fun getFollowerCount(profileId: Long): Long {
        return followerReader.readFollowerCount(profileId)
    }

    fun getFollower(profileId: Long): List<UserProfile> {
        return followerReader.readFollower(profileId)
    }
}