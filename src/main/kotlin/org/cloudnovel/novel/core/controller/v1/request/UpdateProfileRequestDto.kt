package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.domain.profile.profile.UserProfileUpdateRequest

data class UpdateProfileRequestDto(
        val userId: Long,
        val bio: String
) {

    fun toRequest(): UserProfileUpdateRequest {
        return UserProfileUpdateRequest(bio)
    }
}
