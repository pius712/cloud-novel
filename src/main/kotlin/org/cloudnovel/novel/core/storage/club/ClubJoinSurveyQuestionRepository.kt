package org.cloudnovel.novel.core.storage.club

import org.springframework.data.jpa.repository.JpaRepository

interface ClubJoinSurveyQuestionRepository : JpaRepository<ClubJoinSurveyQuestionEntity, Long> {
    fun findByClubId(clubId: Long): List<ClubJoinSurveyQuestionEntity>


}