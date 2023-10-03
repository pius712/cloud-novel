package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.JoinClubRequestDto
import org.cloudnovel.novel.core.domain.bookclub.ClubMember
import org.cloudnovel.novel.core.domain.bookclub.member.ClubJoinService
import org.cloudnovel.novel.core.domain.bookclub.member.ClubMemberProfile
import org.cloudnovel.novel.core.domain.bookclub.member.ClubMemberReadService
import org.cloudnovel.novel.core.domain.bookclub.member.JoinSurveyAnswer
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/club/{clubId}/member")
class ClubMemberController(
        val clubJoinService: ClubJoinService,
        private val clubMemberReadService: ClubMemberReadService) {


    /**
     * 참여 멤버들
     * */
    @GetMapping("/list")
    fun getClubMember(@PathVariable clubId: Long): ApiResponse<List<ClubMemberProfile>> {
        val members = clubMemberReadService.getClubMembers(clubId)

        return ApiResponse.ok(members)
    }

    /**
     * @참여 요청
     * */
    @PostMapping("/join")
    fun requestJoin(
            @PathVariable clubId: Long,
            @RequestBody joinClubRequestDto: JoinClubRequestDto,
    ): ApiResponse<Any> {
        clubJoinService.requestJoin(
                ClubMember(clubId, joinClubRequestDto.profileId),
                joinClubRequestDto.surveys.map { JoinSurveyAnswer(it.surveyId, it.answer) })

        return ApiResponse.ok()
    }
}