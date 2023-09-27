package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.domain.club.ClubCreateRequest

data class CreateClubRequestDto(
        val name: String,
        val description: String
) {

    fun toRequest(): ClubCreateRequest {
        return ClubCreateRequest(name, description)
    }
}
