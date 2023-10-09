package org.cloudnovel.novel.core.domain.profile.following

import org.springframework.stereotype.Service

@Service
class FollowingService(
        private val followingWriter: FollowingWriter,
) {

    fun follow(profileId: Long, targetProfileId: Long) {
        followingWriter.follow(profileId, targetProfileId)
    }

    fun unfollow(profileId: Long, targetProfileId: Long) {
        followingWriter.unfollow(profileId, targetProfileId)
    }
}