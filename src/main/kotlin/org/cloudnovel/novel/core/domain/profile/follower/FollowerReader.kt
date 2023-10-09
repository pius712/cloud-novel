package org.cloudnovel.novel.core.domain.profile.follower

import org.cloudnovel.novel.core.domain.profile.profile.UserProfile
import org.cloudnovel.novel.core.domain.profile.profile.UserProfileReader
import org.cloudnovel.novel.core.storage.profile.FollowerRepository
import org.springframework.stereotype.Component

@Component
class FollowerReader(private val followerRepository: FollowerRepository,
                     private val userProfileReader: UserProfileReader) {


    fun readFollowerCount(profileId: Long): Long {
        return followerRepository.countByProfileId(profileId)
    }

    fun readFollower(profileId: Long): List<UserProfile> {
        val followerIds = followerRepository.findByProfileId(profileId).map { it.followerId }
        return userProfileReader.readAllById(followerIds)
    }
}