package org.cloudnovel.novel.core.storage.club

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ClubSurveyAnswerRepository : JpaRepository<ClubSurveyAnswerEntity, Long> {


    fun findByClubMemberId(clubMemberId: Long): List<ClubSurveyAnswerEntity>
}