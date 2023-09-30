package org.cloudnovel.novel.core.domain.bookclub.survey

data class JoinSurveyRequest(
        val sequence: Long,
        val question: String
) {
}