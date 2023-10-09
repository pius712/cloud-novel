package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.bookclub.club.Club

data class ProfileGuestClubResponseDto(
        private val clubs: List<ClubResponseDto>
) {

    companion object {
        fun of(clubs: List<Club>): ProfileGuestClubResponseDto {
            return ProfileGuestClubResponseDto(clubs.map { ClubResponseDto(it) })
        }
    }

}