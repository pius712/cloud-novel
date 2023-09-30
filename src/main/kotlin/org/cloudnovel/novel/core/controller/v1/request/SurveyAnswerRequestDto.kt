package org.cloudnovel.novel.core.controller.v1.request

data class SurveyAnswerRequestDto(
        val surveyId: Long,
        val sequence: Long,
        val answer: String,
)
