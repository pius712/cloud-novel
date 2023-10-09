package org.cloudnovel.novel.core.domain.profile.following

import org.cloudnovel.novel.core.domain.profile.profile.Profile
import org.springframework.stereotype.Service

@Service
class FollowingReadService(private val followingReader: FollowingReader) {


    fun getFollowingCount(profileId: Long): Long {
        return followingReader.readFollowingCount(profileId)
    }

    fun getFollowing(profileId: Long): List<Profile> {
        return followingReader.readFollowing(profileId)
    }
}