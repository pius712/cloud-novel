package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.bookclub.club.Club

data class ProfileJoiningClubResponseDto(
        val hostClubs: List<ClubResponseDto>,
        val guestClubs: List<ClubResponseDto>,
) {
    constructor(hostClubs: List<Club>, guestClubs: List<Club>) : this(
            hostClubs.map { ClubResponseDto(it) },
            guestClubs.map { ClubResponseDto(it) }
    )
}