package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.bookclub.club.ClubHost

data class ClubHostResponseDto(
        val profileId: Long,
        val nickname: String,
        val bio: String
) {

    constructor(clubHost: ClubHost) : this(clubHost.profileId, clubHost.nickname, clubHost.bio)
}