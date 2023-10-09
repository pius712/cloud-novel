package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.CreateProfileRequestDto
import org.cloudnovel.novel.core.controller.v1.request.UpdateProfileRequestDto
import org.cloudnovel.novel.core.domain.profile.profile.UserProfile
import org.cloudnovel.novel.core.domain.profile.profile.UserProfileReadService
import org.cloudnovel.novel.core.domain.profile.profile.UserProfileService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/profile")
class UserProfileController(
        private val userProfileReadService: UserProfileReadService,
        private val userProfileService: UserProfileService) {

    @PostMapping()
    fun register(
            @RequestBody createProfileRequestDto: CreateProfileRequestDto
    ): ApiResponse<Long> {
        return ApiResponse.ok(userProfileService.register(
                createProfileRequestDto.userId, createProfileRequestDto.toRequest()))
    }

    @GetMapping("{id}")
    fun getProfile(
            @PathVariable id: Long
    ): ApiResponse<UserProfile> {
        return ApiResponse.ok(userProfileReadService.getProfileById(id));
    }

    @GetMapping()
    fun getProfileByUserId(@RequestParam("userId") userId: Long): ApiResponse<UserProfile> {
        return ApiResponse.ok(userProfileReadService.getProfileByUserId(userId));
    }

    @PostMapping("/update")
    fun update(
            @RequestBody updateProfileRequestDto: UpdateProfileRequestDto
    ): ApiResponse<UserProfile> {
        return ApiResponse.ok(userProfileService.update(updateProfileRequestDto.userId, updateProfileRequestDto.toRequest()))
    }
}