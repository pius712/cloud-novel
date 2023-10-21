package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.UpdateProfileInterestRequestDto
import org.cloudnovel.novel.core.controller.v1.response.ProfileInterestListResponseDto
import org.cloudnovel.novel.core.domain.profile.profileinterest.ProfileInterestService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/profile/{profileId}/interest")
class ProfileInterestController(private val profileInterestService: ProfileInterestService) {

    @PostMapping("/update")
    fun updateInterest(
            @PathVariable profileId: Long,
            @RequestBody updateProfileInterestRequestDto: UpdateProfileInterestRequestDto
    ): ApiResponse<Any> {
        profileInterestService.updateInterest(profileId, updateProfileInterestRequestDto.interestIds)
        return ApiResponse.ok()
    }


    @GetMapping("/list")
    fun getInterest(@PathVariable profileId: Long): ApiResponse<ProfileInterestListResponseDto> {
        val interests = profileInterestService.getInterestByProfile(profileId)
        return ApiResponse.ok(ProfileInterestListResponseDto.of(interests))
    }

}