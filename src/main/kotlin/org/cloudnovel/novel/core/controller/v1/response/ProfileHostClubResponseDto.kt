package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.bookclub.club.Club

data class ProfileHostClubResponseDto(
        val clubs: List<ClubResponseDto>

) {
    companion object {
        fun of(clubs: List<Club>): ProfileHostClubResponseDto {
            return ProfileHostClubResponseDto(clubs.map { ClubResponseDto(it) })
        }
    }
}