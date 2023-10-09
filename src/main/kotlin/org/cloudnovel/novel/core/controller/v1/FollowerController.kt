package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.RemoveFollowerRequestDto
import org.cloudnovel.novel.core.controller.v1.response.ProfileListResponseDto
import org.cloudnovel.novel.core.domain.profile.follower.FollowerReadService
import org.cloudnovel.novel.core.domain.profile.follower.FollowerService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/profile/{profileId}/follower")
class FollowerController(private val followerReadService: FollowerReadService,
                         private val followerService: FollowerService) {

    @GetMapping("/list")
    fun getFollower(@PathVariable profileId: Long): ApiResponse<ProfileListResponseDto> {
        val profiles = followerReadService.getFollower(profileId);
        return ApiResponse.ok(ProfileListResponseDto.of(profiles));
    }

    @PostMapping("/remove")
    fun removeFollower(@PathVariable profileId: Long,
                       @RequestBody removeFollowerRequestDto: RemoveFollowerRequestDto): ApiResponse<Any> {
        followerService.removeFollower(profileId, removeFollowerRequestDto.followerId);

        return ApiResponse.ok();
    }
}