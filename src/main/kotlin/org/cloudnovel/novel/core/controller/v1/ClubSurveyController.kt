package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.CreateJoinSurveyRequestDto
import org.cloudnovel.novel.core.domain.club.survey.JoinSurvey
import org.cloudnovel.novel.core.domain.club.survey.JoinSurveyRequest
import org.cloudnovel.novel.core.domain.club.survey.JoinSurveyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/club")
class ClubSurveyController(private val surveyService: JoinSurveyService) {


    @GetMapping("{id}/survey")
    fun getSurveys(@PathVariable id: Long): List<JoinSurvey> {
        return surveyService.getSurveys(id)
    }

    @PostMapping("{id}/survey")
    fun registerSurvey(@PathVariable id: Long, @RequestBody joinSurveyRequestDto: List<CreateJoinSurveyRequestDto>): List<JoinSurvey> {
        return surveyService.register(id, joinSurveyRequestDto.map { JoinSurveyRequest(it.sequence, it.question) })
    }

}