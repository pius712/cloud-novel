package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.bookclub.club.Club

data class ClubResponseDto(
        val host: ClubHostResponseDto,
        val name: String,
        val description: String,
) {

    constructor(club: Club) : this(ClubHostResponseDto(club.host), club.name, club.description)
}