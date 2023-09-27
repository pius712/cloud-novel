package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.domain.profile.ProfileUpdateRequest

data class UpdateProfileRequestDto(
        val userId: Long,
        val bio: String
) {

    fun toRequest(): ProfileUpdateRequest {
        return ProfileUpdateRequest(bio)
    }
}
