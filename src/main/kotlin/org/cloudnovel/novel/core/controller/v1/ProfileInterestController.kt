package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.UpdateInterestRequestDto
import org.cloudnovel.novel.core.controller.v1.response.InterestListResponseDto
import org.cloudnovel.novel.core.domain.profile.profileinterest.ProfileInterestService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/profile/{profileId}/interest")
class ProfileInterestController(private val profileInterestService: ProfileInterestService) {

    @PostMapping("update")
    fun updateInterest(
            @PathVariable profileId: Long,
            @RequestBody updateInterestRequestDto: UpdateInterestRequestDto
    ) {
        profileInterestService.updateInterest(profileId, updateInterestRequestDto.interestIds)
    }


    @GetMapping("/list")
    fun getInterest(@PathVariable profileId: Long): ApiResponse<InterestListResponseDto> {
        val interests = profileInterestService.getInterestByProfile(profileId)
        return ApiResponse.ok(InterestListResponseDto(interests))
    }

}