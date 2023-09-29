package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.CreateClubRequestDto
import org.cloudnovel.novel.core.controller.v1.request.JoinClubRequestDto
import org.cloudnovel.novel.core.controller.v1.request.UpdateClubRecruitStatusRequestDto
import org.cloudnovel.novel.core.domain.club.Club
import org.cloudnovel.novel.core.domain.club.ClubService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/club")
class ClubController(
        private val clubService: ClubService
) {

    @PostMapping()
    fun register(
            @RequestBody createClubRequestDto: CreateClubRequestDto
    ): ApiResponse<Long> {
        return ApiResponse.ok(clubService.register(createClubRequestDto.profileId, createClubRequestDto.toRequest()))
    }

    @GetMapping("{id}")
    fun getClub(@PathVariable id: Long): ApiResponse<Club> {
        return ApiResponse.ok(clubService.getClub(id));
    }

    @GetMapping("{id}/participants")
    fun getParticipants(@PathVariable id: Long) {
        return clubService.getParticipants(id)
    }

    @PostMapping("{id}/recruitment/open")
    fun updateClubRecruitStatus(
            @PathVariable id: Long,
            @RequestBody updateClubRecruitStatusRequestDto: UpdateClubRecruitStatusRequestDto) {
        clubService.openRecruitment(id, updateClubRecruitStatusRequestDto.status)
    }


    @PostMapping("/join")
    fun join(
            @RequestBody joinClubRequestDto: JoinClubRequestDto
    ) {

    }
}