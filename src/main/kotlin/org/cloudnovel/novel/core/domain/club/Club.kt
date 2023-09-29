package org.cloudnovel.novel.core.domain.club

data class Club(
        val host: ClubHost,
        val name: String,
        val description: String,
//        val participant: ClubParticipant
) {
}