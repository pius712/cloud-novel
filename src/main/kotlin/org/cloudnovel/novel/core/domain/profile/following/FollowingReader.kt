package org.cloudnovel.novel.core.domain.profile.following

import org.cloudnovel.novel.core.domain.profile.profile.UserProfile
import org.cloudnovel.novel.core.domain.profile.profile.UserProfileReader
import org.cloudnovel.novel.core.storage.profile.FollowingRepository
import org.springframework.stereotype.Component

@Component
class FollowingReader(private val followingRepository: FollowingRepository,
                      private val userProfileReader: UserProfileReader) {


    fun readFollowing(profileId: Long): List<UserProfile> {
        val followingIds = followingRepository.findByProfileId(profileId).map { it.followingId }
        return userProfileReader.readAllById(followingIds)
    }

    fun readFollowingCount(profileId: Long): Long {
        return followingRepository.countByProfileId(profileId)
    }

}