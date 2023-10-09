package org.cloudnovel.novel.core.domain.profile.follower

import org.cloudnovel.novel.core.storage.profile.FollowerRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.stereotype.Component

@Component
class FollowerWriter(private val followerRepository: FollowerRepository) {
    fun remove(profileId: Long, followerId: Long) {
        followerRepository.findByProfileIdAndFollowerId(profileId, followerId)
                ?: throw CoreApiException(CoreExceptionType.NOT_FOLLOWER_PROFILER)
        
        followerRepository.deleteByProfileIdAndFollowerId(profileId, followerId)
    }

}