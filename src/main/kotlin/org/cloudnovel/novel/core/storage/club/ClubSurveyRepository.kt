package org.cloudnovel.novel.core.storage.club

import org.springframework.data.jpa.repository.JpaRepository

interface ClubSurveyRepository : JpaRepository<ClubJoinSurveyEntity, Long> {
    fun findByClubId(clubId: Long): List<ClubJoinSurveyEntity>
}