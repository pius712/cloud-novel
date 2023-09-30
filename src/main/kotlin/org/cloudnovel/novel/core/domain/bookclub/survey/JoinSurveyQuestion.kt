package org.cloudnovel.novel.core.domain.bookclub.survey

data class JoinSurveyQuestion(
        val id: Long,
        val clubId: Long,
        val sequence: Long,
        val question: String) {

}