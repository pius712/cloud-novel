package org.cloudnovel.novel.core.controller.v1.request

data class CreateJoinSurveyRequestDto(

        val surveys: List<SurveyRequestDto>

) {

}

data class SurveyRequestDto(val sequence: Long,
                            val question: String)