package org.cloudnovel.novel.core.controller.v1.request

data class CreateJoinSurveyRequestDto(
        val sequence: Long,
        val question: String
) {

}