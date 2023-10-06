package org.cloudnovel.novel.core.domain.profile.profile

data class ProfileCreateRequest(
        val nickname: String,
        val bio: String,
) {
}