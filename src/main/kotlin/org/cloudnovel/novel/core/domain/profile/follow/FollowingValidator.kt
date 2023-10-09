package org.cloudnovel.novel.core.domain.profile.follow

import org.springframework.stereotype.Component

@Component
class FollowingValidator(private val followReader: FollowReader) {

    fun canFollow(profileId: Long, targetProfileId: Long) {
        followReader.readFollowing(profileId)
    }
}