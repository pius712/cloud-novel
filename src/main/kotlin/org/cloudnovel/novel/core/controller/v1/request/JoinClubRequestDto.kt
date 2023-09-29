package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.domain.club.ClubJoinRequest

data class JoinClubRequestDto(
        val answer: String
) {

    fun toRequest(): ClubJoinRequest {
        return ClubJoinRequest(answer)
    }
}
