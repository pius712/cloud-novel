package org.cloudnovel.novel.core.domain.bookclub.survey

import org.cloudnovel.novel.core.storage.club.ClubJoinSurveyQuestionEntity
import org.cloudnovel.novel.core.storage.club.ClubSurveyQuestionRepository
import org.springframework.stereotype.Component

@Component
class JoinSurveyReader(private val repository: ClubSurveyQuestionRepository) {


    fun readByClub(clubId: Long): List<JoinSurveyQuestion> {

        return repository.findByClubId(clubId).map(::toJoinSurvey)
    }

    fun toJoinSurvey(joinSurveyEntity: ClubJoinSurveyQuestionEntity): JoinSurveyQuestion {
        return JoinSurveyQuestion(
                joinSurveyEntity.id!!,
                joinSurveyEntity.clubId,
                joinSurveyEntity.sequence,
                joinSurveyEntity.question
        )
    }
}