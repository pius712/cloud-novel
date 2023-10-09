package org.cloudnovel.novel.core.domain.profile.follower

import org.springframework.stereotype.Service

@Service
class FollowerReadService(private val followerReader: FollowerReader) {


    fun getFollowerCount(profileId: Long) {
        followerReader.readFollowerCount(profileId)
    }

    fun getFollower(profileId: Long) {
        followerReader.readFollower(profileId)
    }
}