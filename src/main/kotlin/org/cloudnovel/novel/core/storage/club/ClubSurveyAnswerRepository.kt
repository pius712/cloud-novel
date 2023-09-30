package org.cloudnovel.novel.core.storage.club

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface SurveyAnswerRepository : JpaRepository<SurveyAnswerEntity, Long> {

    fun findByAndSurveyIdAndProfileIdIn(surveyId: Long, profileIds: List<Long>): List<SurveyAnswerEntity>
}