package org.cloudnovel.novel.core.domain.club

data class ClubJoinSurveyRequest(
        val sequence: Long,
        val question: String
) {
}