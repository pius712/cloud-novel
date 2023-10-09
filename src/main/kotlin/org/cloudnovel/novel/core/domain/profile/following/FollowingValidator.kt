package org.cloudnovel.novel.core.domain.profile.following

import org.springframework.stereotype.Component

@Component
class FollowingValidator(private val followingReader: FollowingReader) {

    fun canFollow(profileId: Long, targetProfileId: Long) {
        followingReader.readFollowing(profileId)
    }
}