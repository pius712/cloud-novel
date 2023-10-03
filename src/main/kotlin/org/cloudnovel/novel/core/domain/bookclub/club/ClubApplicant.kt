package org.cloudnovel.novel.core.domain.bookclub.club

data class ClubApplicant(
        val clubMemberId: Long,
        val nickname: String,
        val bio: String,
//        val answer: List<JoinSurvey>
)
