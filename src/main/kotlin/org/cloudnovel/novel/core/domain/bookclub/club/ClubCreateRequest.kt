package org.cloudnovel.novel.core.domain.bookclub.club

import org.cloudnovel.novel.core.common.enum.ClubVisibilityStatus

data class ClubCreateRequest(
        val name: String,
        val description: String,
        val visibility: ClubVisibilityStatus,
) {
}