package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.bookclub.club.Club

data class ProfileGuestClubResponseDto(
        val clubs: List<ClubResponseDto>
) {

    constructor(clubs: List<Club>) : this(clubs.map { ClubResponseDto(it) })
}