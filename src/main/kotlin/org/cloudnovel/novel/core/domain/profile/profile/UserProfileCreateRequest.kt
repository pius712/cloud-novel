package org.cloudnovel.novel.core.domain.profile.profile

data class UserProfileCreateRequest(
        val nickname: String,
        val bio: String,
) {
}