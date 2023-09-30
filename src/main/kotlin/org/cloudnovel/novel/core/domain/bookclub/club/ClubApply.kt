package org.cloudnovel.novel.core.domain.bookclub.club

data class ClubApplication(
        val clubMemberId: Long,
        val nickname: String,
        val bio: String,
        val survey: List<JoinSurvey>
) {
}