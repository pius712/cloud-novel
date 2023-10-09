package org.cloudnovel.novel.core.domain.profile.following

import org.cloudnovel.novel.core.storage.profile.FollowingEntity
import org.cloudnovel.novel.core.storage.profile.FollowingRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.stereotype.Component

@Component
class FollowingWriter(
        private val followingRepository: FollowingRepository,
        private val followingValidator: FollowingValidator,
) {


    fun follow(profileId: Long, targetId: Long) {
        val hasFollowing = checkFollowing(profileId, targetId)
        if (!hasFollowing) throw CoreApiException(CoreExceptionType.ALREADY_FOLLOWING)
        followingRepository.save(FollowingEntity(
                profileId,
                targetId
        ))
    }


    fun unfollow(profileId: Long, targetId: Long) {
        val hasFollowing = checkFollowing(profileId, targetId)
        if (!hasFollowing) throw CoreApiException(CoreExceptionType.NOT_FOLLOWING_PROFILE)
        followingRepository.deleteByProfileIdAndFollowingId(profileId, targetId)
    }


    private fun checkFollowing(profileId: Long, targetId: Long): Boolean {
        val found = followingRepository.findByProfileId(profileId);
        return found.find { it.followingId == targetId } != null

    }

}