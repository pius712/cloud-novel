package org.cloudnovel.novel.core.domain.bookclub.member

data class ClubMemberProfile(
        val profileId: Long,
        val nickname: String,
        val bio: String
) {
}