package org.cloudnovel.novel.core.controller.v1.request

data class JoinClubRequestDto(
        val profileId: Long,
        val surveys: List<SurveyAnswerRequestDto>
) {
}
