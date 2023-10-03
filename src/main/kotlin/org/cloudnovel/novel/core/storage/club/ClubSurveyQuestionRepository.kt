package org.cloudnovel.novel.core.storage.club

import org.springframework.data.jpa.repository.JpaRepository

interface ClubSurveyQuestionRepository : JpaRepository<ClubJoinSurveyQuestionEntity, Long> {
    fun findByClubId(clubId: Long): List<ClubJoinSurveyQuestionEntity>

    fun findByIdIn(ids: List<Long>): List<ClubJoinSurveyQuestionEntity>

}