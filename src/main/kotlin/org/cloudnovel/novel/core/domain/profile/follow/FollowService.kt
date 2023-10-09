package org.cloudnovel.novel.core.domain.profile.follow

import org.springframework.stereotype.Service

@Service
class FollowService(
        private val followWriter: FollowWriter,
) {

    fun follow(profileId: Long, targetProfileId: Long) {
        followWriter.follow(profileId, targetProfileId)
    }

    fun unfollow(profileId: Long, targetProfileId: Long) {
        followWriter.unfollow(profileId, targetProfileId)
    }


    fun removeFollower(profileId: Long, targetProfileId: Long): Unit {
        return followWriter.remove(profileId, targetProfileId)
    }
}