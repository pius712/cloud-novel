package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.domain.bookclub.club.ClubApplicant
import org.cloudnovel.novel.core.domain.bookclub.club.ClubApply
import org.cloudnovel.novel.core.domain.bookclub.club.ClubMemberManageService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/club/{clubId}/apply")
class ClubApplicantController(val clubMemberManageService: ClubMemberManageService) {


    @GetMapping()
    fun a(@PathVariable clubId: Long): ApiResponse<List<ClubApplicant>> {
        val result = clubMemberManageService.getApplicant(clubId)
        return ApiResponse.ok(result)
    }

    @GetMapping("/member/{memberId}")
    fun b(@PathVariable memberId: Long): ApiResponse<ClubApply> {
        val result = clubMemberManageService.getApply(memberId)
        return ApiResponse.ok(result)
    }
}