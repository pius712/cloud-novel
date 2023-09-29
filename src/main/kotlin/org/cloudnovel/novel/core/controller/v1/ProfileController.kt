package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.CreateProfileRequestDto
import org.cloudnovel.novel.core.controller.v1.request.UpdateProfileRequestDto
import org.cloudnovel.novel.core.domain.profile.Profile
import org.cloudnovel.novel.core.domain.profile.ProfileService
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/profile")
class ProfileController(private val profileService: ProfileService) {

    @PostMapping()
    fun register(
            @RequestBody createProfileRequestDto: CreateProfileRequestDto
    ): Long {
        return profileService.register(
                createProfileRequestDto.userId, createProfileRequestDto.toRequest())
    }

    @GetMapping("{id}")
    fun getProfile(
            @PathVariable id: Long
    ): Profile {
        throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND)
//        return profileService.getProfileById(id);
    }

    @GetMapping()
    fun getProfileByUserId(@RequestParam("userId") userId: Long): Profile {
        return profileService.getProfileByUserId(userId);
    }

    @PostMapping("/update")
    fun update(
            @RequestBody updateProfileRequestDto: UpdateProfileRequestDto
    ): Profile {
        return profileService.update(updateProfileRequestDto.userId, updateProfileRequestDto.toRequest())

    }
}