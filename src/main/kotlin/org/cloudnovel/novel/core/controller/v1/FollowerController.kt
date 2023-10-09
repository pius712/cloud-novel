package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.domain.profile.follower.FollowerReadService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/profile/{profileId}/follower")
class FollowerController(private val followerReadService: FollowerReadService) {

    @GetMapping("/list")
    fun getFollower(@PathVariable profileId: Long) {
        val profiles = followerReadService.getFollower(profileId);
        return profiles
    }

}