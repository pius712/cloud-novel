package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.profile.profile.UserProfile

data class ProfileListResponseDto(
        val profiles: List<ProfileResponseDto>,
) {
    companion object {
        fun of(profiles: List<UserProfile>): ProfileListResponseDto {
            return ProfileListResponseDto(profiles.map(::ProfileResponseDto))
        }
    }
}
