package org.cloudnovel.novel.core.domain.bookclub.club

data class Club(
        val host: ClubHost,
        val name: String,
        val description: String,
) {
}