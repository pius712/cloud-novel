package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.common.enum.ClubVisibilityStatus
import org.cloudnovel.novel.core.domain.bookclub.club.ClubCreateRequest

data class CreateClubRequestDto(
        val profileId: Long,
        val name: String,
        val description: String,
        val visibility: ClubVisibilityStatus
) {

    fun toRequest(): ClubCreateRequest {
        return ClubCreateRequest(name, description, visibility)
    }
}
