package org.cloudnovel.novel.core.domain.profile.following

import org.cloudnovel.novel.core.domain.profile.profile.Profile
import org.cloudnovel.novel.core.domain.profile.profile.ProfileReader
import org.cloudnovel.novel.core.storage.profile.FollowingRepository
import org.springframework.stereotype.Component

@Component
class FollowingReader(private val followingRepository: FollowingRepository,
                      private val profileReader: ProfileReader) {


    fun readFollowing(profileId: Long): List<Profile> {
        val followingIds = followingRepository.findByProfileId(profileId).map { it.followingId }
        return profileReader.readAllById(followingIds)
    }

    fun readFollowingCount(profileId: Long): Long {
        return followingRepository.countByProfileId(profileId)
    }

}