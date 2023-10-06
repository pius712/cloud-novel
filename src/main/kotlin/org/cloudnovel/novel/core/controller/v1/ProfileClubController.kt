package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.response.ProfileGuestClubResponseDto
import org.cloudnovel.novel.core.controller.v1.response.ProfileHostClubResponseDto
import org.cloudnovel.novel.core.controller.v1.response.ProfileJoiningClubResponseDto
import org.cloudnovel.novel.core.domain.bookclub.club.ClubReadService
import org.cloudnovel.novel.core.domain.bookclub.member.ClubMemberReadService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/profile/{profileId}/club")
class ProfileClubController(private val clubReadService: ClubReadService,
                            private val clubMemberReadService: ClubMemberReadService) {

    @GetMapping
    fun getHostClub(@PathVariable profileId: Long): ApiResponse<ProfileHostClubResponseDto> {
        val clubByProfile = clubReadService.getClubByProfile(profileId);

        return ApiResponse.ok(ProfileHostClubResponseDto(clubByProfile))
    }

    @GetMapping
    fun getGuestClub(@PathVariable profileId: Long): ApiResponse<ProfileGuestClubResponseDto> {
        val clubs = clubMemberReadService.getClubByProfile(profileId)

        return ApiResponse.ok(ProfileGuestClubResponseDto(clubs))
    }

    @GetMapping()
    fun getJoiningClub(@PathVariable profileId: Long): ApiResponse<ProfileJoiningClubResponseDto> {
        val hostClubs = clubReadService.getClubByProfile(profileId);

        val guestClubs = clubMemberReadService.getClubByProfile(profileId)

        return ApiResponse.ok(ProfileJoiningClubResponseDto(hostClubs, guestClubs))
    }


}