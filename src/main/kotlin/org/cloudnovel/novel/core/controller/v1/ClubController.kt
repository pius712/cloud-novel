package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.CreateClubRequestDto
import org.cloudnovel.novel.core.controller.v1.request.JoinClubRequestDto
import org.cloudnovel.novel.core.domain.club.Club
import org.cloudnovel.novel.core.domain.club.ClubService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/club")
class ClubController(
        private val clubService: ClubService
) {


    @GetMapping("{id}")
    fun getClub(@PathVariable id: Long): Club {
        return clubService.getClub();
    }

    @GetMapping("{id}/survey")
    fun getSurvey() {

    }

    @PostMapping("{id}/survey")
    fun submitSurvey() {

    }

    @PostMapping()
    fun register(
            @RequestBody createClubRequestDto: CreateClubRequestDto
    ) {
        return clubService.register(createClubRequestDto.toRequest())
    }


    @PostMapping("/join")
    fun join(
            @RequestBody joinClubRequestDto: JoinClubRequestDto
    ) {
        return clubService.join(joinClubRequestDto.toRequest())
    }
}