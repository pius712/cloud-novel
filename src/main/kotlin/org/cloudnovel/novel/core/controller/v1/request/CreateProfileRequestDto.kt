package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.domain.profile.profile.ProfileCreateRequest

data class CreateProfileRequestDto(
        val userId: Long,
        val nickname: String,
        val bio: String
) {
    fun toRequest(): ProfileCreateRequest {
        return ProfileCreateRequest(nickname, bio)
    }
}