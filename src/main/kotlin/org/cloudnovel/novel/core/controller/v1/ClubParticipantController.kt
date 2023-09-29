package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.domain.club.participant.ClubParticipant
import org.cloudnovel.novel.core.domain.club.participant.ClubParticipantService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/club/{id}/participant")
class ClubParticipantController(private val clubParticipantService: ClubParticipantService) {


    @GetMapping
    fun getParticipants(@PathVariable id: Long): ApiResponse<List<ClubParticipant>> {
        return ApiResponse.ok(clubParticipantService.participants(id));
    }

}