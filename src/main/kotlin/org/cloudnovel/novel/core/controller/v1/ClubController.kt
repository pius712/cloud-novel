package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.CreateClubRequestDto
import org.cloudnovel.novel.core.controller.v1.request.CreateJoinSurveyRequestDto
import org.cloudnovel.novel.core.controller.v1.request.UpdateClubOpenRequestDto
import org.cloudnovel.novel.core.domain.bookclub.club.Club
import org.cloudnovel.novel.core.domain.bookclub.club.ClubManageService
import org.cloudnovel.novel.core.domain.bookclub.club.ClubReadService
import org.cloudnovel.novel.core.domain.bookclub.survey.JoinSurveyQuestion
import org.cloudnovel.novel.core.domain.bookclub.survey.JoinSurveyRequest
import org.cloudnovel.novel.core.domain.bookclub.survey.JoinSurveyService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/club")
class ClubController(
        private val clubManageService: ClubManageService,
        private val clubReadService: ClubReadService,
        private val surveyService: JoinSurveyService
) {

    @PostMapping()
    fun register(
            @RequestBody createClubRequestDto: CreateClubRequestDto
    ): ApiResponse<Long> {
        return ApiResponse.ok(clubManageService.register(createClubRequestDto.profileId, createClubRequestDto.toRequest()))
    }

    @GetMapping("{id}")
    fun getClub(@PathVariable id: Long): ApiResponse<Club> {
        return ApiResponse.ok(clubReadService.getClub(id));
    }

    @PostMapping("{id}/recruitment/open")
    fun updateClubRecruitStatus(
            @PathVariable id: Long,
            @RequestBody updateClubOpenRequestDto: UpdateClubOpenRequestDto): ApiResponse<Any> {
        clubManageService.openRecruitment(id, updateClubOpenRequestDto.status)

        return ApiResponse.ok()
    }


    @GetMapping("{id}/join/survey")
    fun getSurveys(@PathVariable id: Long): ApiResponse<List<JoinSurveyQuestion>> {
        return ApiResponse.ok(surveyService.getSurveys(id))
    }

    @PostMapping("{id}/join/survey/register")
    fun registerSurvey(@PathVariable id: Long, @RequestBody joinSurveyRequestDto: CreateJoinSurveyRequestDto): ApiResponse<List<JoinSurveyQuestion>> {
        return ApiResponse.ok(surveyService.register(id, joinSurveyRequestDto.surveys.map { JoinSurveyRequest(it.sequence, it.question) }))
    }


}