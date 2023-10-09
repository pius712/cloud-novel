package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.RemoveFollowerRequestDto
import org.cloudnovel.novel.core.controller.v1.response.ProfileListResponseDto
import org.cloudnovel.novel.core.domain.profile.follow.FollowReadService
import org.cloudnovel.novel.core.domain.profile.follow.FollowService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/profile/{profileId}/follower")
class FollowerController(private val followReadService: FollowReadService,
                         private val followService: FollowService) {

    @GetMapping("/list")
    fun getFollower(@PathVariable profileId: Long): ApiResponse<ProfileListResponseDto> {
        val profiles = followReadService.getFollower(profileId);
        return ApiResponse.ok(ProfileListResponseDto.of(profiles));
    }

    @PostMapping("/remove")
    fun removeFollower(@PathVariable profileId: Long,
                       @RequestBody removeFollowerRequestDto: RemoveFollowerRequestDto): ApiResponse<Any> {
        followService.removeFollower(profileId, removeFollowerRequestDto.followerId);

        return ApiResponse.ok();
    }
}