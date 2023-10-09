package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.profile.profile.UserProfile

data class ProfileResponseDto(
        val id: Long,
        val nickname: String,
        val bio: String
) {

    constructor(profile: UserProfile) : this(profile.id, profile.nickname, profile.bio)
}
