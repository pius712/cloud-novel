package org.cloudnovel.novel.core.domain.profile.follower

import org.springframework.stereotype.Service

@Service
class FollowerService(private val followerWriter: FollowerWriter) {

    fun removeFollower(profileId: Long, targetProfileId: Long): Unit {
        return followerWriter.remove(profileId, targetProfileId)
    }

}