package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.common.enum.ClubRecruitStatus

data class UpdateClubRecruitStatusRequestDto(
        val status: ClubRecruitStatus
) {
}