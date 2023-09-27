package org.cloudnovel.novel.core.domain.profile

data class ProfileCreateRequest(
        val nickname: String,
        val bio: String,
) {
}