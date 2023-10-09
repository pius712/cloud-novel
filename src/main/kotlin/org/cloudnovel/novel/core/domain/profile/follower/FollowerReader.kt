package org.cloudnovel.novel.core.domain.profile.follower

import org.cloudnovel.novel.core.domain.profile.profile.Profile
import org.cloudnovel.novel.core.domain.profile.profile.ProfileReader
import org.cloudnovel.novel.core.storage.profile.FollowerRepository
import org.springframework.stereotype.Component

@Component
class FollowerReader(private val followerRepository: FollowerRepository,
                     private val profileReader: ProfileReader) {


    fun readFollowerCount(profileId: Long): Long {
        return followerRepository.countByProfileId(profileId)
    }

    fun readFollower(profileId: Long): List<Profile> {
        val followerIds = followerRepository.findByProfileId(profileId).map { it.followerId }
        return profileReader.readAllById(followerIds)
    }
}