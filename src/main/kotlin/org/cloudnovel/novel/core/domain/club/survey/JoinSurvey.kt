package org.cloudnovel.novel.core.domain.club.survey

data class JoinSurvey(
        val id: Long,
        val clubId: Long,
        val sequence: Long,
        val question: String) {
}