package org.cloudnovel.novel.core.domain.profile.follow

import org.cloudnovel.novel.core.storage.profile.FollowEntity
import org.cloudnovel.novel.core.storage.profile.FollowRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.stereotype.Component

@Component
class FollowWriter(
        private val followRepository: FollowRepository,
) {


    fun follow(profileId: Long, targetId: Long) {
        val hasFollowing = isFollowing(profileId, targetId)
        if (hasFollowing) throw CoreApiException(CoreExceptionType.ALREADY_FOLLOWING)
        followRepository.save(FollowEntity(
                profileId,
                targetId
        ))
    }


    fun unfollow(profileId: Long, targetId: Long) {
        val hasFollowing = isFollowing(profileId, targetId)
        if (hasFollowing) throw CoreApiException(CoreExceptionType.NOT_FOLLOWING_PROFILE)
        followRepository.deleteByFollowerIdAndFollowingId(profileId, targetId)
    }

    fun remove(profileId: Long, followerId: Long) {
        followRepository.findByFollowingIdAndFollowerId(profileId, followerId)
                ?: throw CoreApiException(CoreExceptionType.NOT_FOLLOWER_PROFILER)

        followRepository.deleteByFollowerIdAndFollowingId(profileId, followerId)
    }

    private fun isFollowing(profileId: Long, targetId: Long): Boolean {
        val found = followRepository.findByFollowerId(profileId);
        val found2 = found.find { it.followingId == targetId }
        return found2 != null
    }
}