package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.domain.profile.profile.UserProfileCreateRequest

data class CreateProfileRequestDto(
        val userId: Long,
        val nickname: String,
        val bio: String
) {
    fun toRequest(): UserProfileCreateRequest {
        return UserProfileCreateRequest(nickname, bio)
    }
}