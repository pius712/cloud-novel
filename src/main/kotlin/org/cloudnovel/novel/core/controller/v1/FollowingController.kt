package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.FollowingRequestDto
import org.cloudnovel.novel.core.controller.v1.request.UnfollowRequestDto
import org.cloudnovel.novel.core.domain.profile.following.FollowingService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/profile/{profileId}/following")
class FollowingController(private val followingService: FollowingService) {


    @GetMapping
    fun getFollowing() {

    }

    @PostMapping("/follow")
    fun follow(
            @PathVariable profileId: Long,
            @RequestBody followingRequestDto: FollowingRequestDto
    ): ApiResponse<Any> {
        followingService.follow(profileId, followingRequestDto.profileId)
        return ApiResponse.ok()
    }


    @PostMapping("/unfollow")
    fun unfollow(
            @PathVariable profileId: Long,
            @RequestBody unfollowingRequestDto: UnfollowRequestDto
    ): ApiResponse<Any> {
        followingService.follow(profileId, unfollowingRequestDto.profileId)
        return ApiResponse.ok()
    }
}