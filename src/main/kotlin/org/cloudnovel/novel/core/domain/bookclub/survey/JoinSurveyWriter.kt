package org.cloudnovel.novel.core.domain.bookclub.survey

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.storage.club.ClubJoinSurveyQuestionEntity
import org.cloudnovel.novel.core.storage.club.ClubJoinSurveyQuestionRepository
import org.springframework.stereotype.Component

@Component
@Transactional
class JoinSurveyWriter(private val clubJoinSurveyQuestionRepository: ClubJoinSurveyQuestionRepository) {

    fun prepareSurvey(clubId: Long, surveys: List<JoinSurveyRequest>): List<JoinSurveyQuestion> {

        return clubJoinSurveyQuestionRepository.saveAll(surveys.map {
            ClubJoinSurveyQuestionEntity(
                    it.sequence,
                    it.question, clubId
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