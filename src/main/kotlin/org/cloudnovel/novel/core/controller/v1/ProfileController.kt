package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.CreateProfileRequestDto
import org.cloudnovel.novel.core.controller.v1.request.UpdateProfileRequestDto
import org.cloudnovel.novel.core.domain.profile.profile.Profile
import org.cloudnovel.novel.core.domain.profile.profile.ProfileService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/profile")
class ProfileController(private val profileService: ProfileService) {

    @PostMapping()
    fun register(
            @RequestBody createProfileRequestDto: CreateProfileRequestDto
    ): ApiResponse<Long> {
        return ApiResponse.ok(profileService.register(
                createProfileRequestDto.userId, createProfileRequestDto.toRequest()))
    }

    @GetMapping("{id}")
    fun getProfile(
            @PathVariable id: Long
    ): ApiResponse<Profile> {
        return ApiResponse.ok(profileService.getProfileById(id));
    }

    @GetMapping()
    fun getProfileByUserId(@RequestParam("userId") userId: Long): ApiResponse<Profile> {
        return ApiResponse.ok(profileService.getProfileByUserId(userId));
    }

    @PostMapping("/update")
    fun update(
            @RequestBody updateProfileRequestDto: UpdateProfileRequestDto
    ): ApiResponse<Profile> {
        return ApiResponse.ok(profileService.update(updateProfileRequestDto.userId, updateProfileRequestDto.toRequest()))
    }
}