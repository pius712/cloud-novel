package org.cloudnovel.novel.core.domain.profile.profile

data class UserProfile(
        val id: Long,
        val nickname: String,
        val bio: String,
        val userId: Long)
