package org.cloudnovel.novel.core.domain.bookclub.survey

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.storage.club.ClubJoinSurveyQuestionEntity
import org.cloudnovel.novel.core.storage.club.ClubSurveyQuestionRepository
import org.springframework.stereotype.Component

@Component
@Transactional
class JoinSurveyWriter(private val clubSurveyQuestionRepository: ClubSurveyQuestionRepository) {

    fun prepareSurvey(clubId: Long, surveys: List<JoinSurveyRequest>): List<JoinSurveyQuestion> {

        return clubSurveyQuestionRepository.saveAll(surveys.map {
            ClubJoinSurveyQuestionEntity(
                    clubId,
                    it.sequence,
                    it.question,
            )
        }).map(::toSurvey)
    }

    fun toSurvey(surveyEntity: ClubJoinSurveyQuestionEntity): JoinSurveyQuestion {
        return JoinSurveyQuestion(
                surveyEntity.id!!,
                surveyEntity.clubId,
                surveyEntity.sequence,
                surveyEntity.question
        )
    }
}