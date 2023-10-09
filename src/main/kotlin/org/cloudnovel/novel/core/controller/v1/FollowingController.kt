package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.FollowingRequestDto
import org.cloudnovel.novel.core.controller.v1.request.UnfollowRequestDto
import org.cloudnovel.novel.core.controller.v1.response.ProfileListResponseDto
import org.cloudnovel.novel.core.domain.profile.follow.FollowReadService
import org.cloudnovel.novel.core.domain.profile.follow.FollowService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/profile/{profileId}/following")
class FollowingController(
        private val followReadService: FollowReadService,
        private val followService: FollowService) {


    @GetMapping("/list")
    fun getFollowing(@PathVariable profileId: Long): ApiResponse<ProfileListResponseDto> {
        val result = followReadService.getFollowing(profileId)
        return ApiResponse.ok(ProfileListResponseDto.of(result))
    }

    @PostMapping("/follow")
    fun follow(
            @PathVariable profileId: Long,
            @RequestBody followingRequestDto: FollowingRequestDto
    ): ApiResponse<Any> {
        followService.follow(profileId, followingRequestDto.profileId)
        return ApiResponse.ok()
    }


    @PostMapping("/unfollow")
    fun unfollow(
            @PathVariable profileId: Long,
            @RequestBody unfollowingRequestDto: UnfollowRequestDto
    ): ApiResponse<Any> {
        followService.follow(profileId, unfollowingRequestDto.profileId)
        return ApiResponse.ok()
    }
}