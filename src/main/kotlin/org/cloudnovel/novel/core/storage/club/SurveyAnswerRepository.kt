package org.cloudnovel.novel.core.storage.club

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface SurveyAnswerRepository : JpaRepository<SurveyAnswerEntity, Long> {

    @Query("select a from SurveyAnswerEntity a inner join a.profileId where a.surveyId= :surveyId")
    fun findByAndSurveyIdAndProfileIdIn(surveyId: Long, profileIds: List<Long>): List<SurveyAnswerEntity>
}