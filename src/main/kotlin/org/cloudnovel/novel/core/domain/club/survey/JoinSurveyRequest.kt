package org.cloudnovel.novel.core.domain.club.survey

data class JoinSurveyRequest(
        val sequence: Long,
        val question: String
) {
}