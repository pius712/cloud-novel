package org.cloudnovel.novel.core.domain.club.survey

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.storage.club.ClubJoinSurveyEntity
import org.cloudnovel.novel.core.storage.club.ClubSurveyRepository
import org.springframework.stereotype.Component

@Component
@Transactional
class JoinSurveyWriter(private val clubSurveyRepository: ClubSurveyRepository) {

    fun prepareSurvey(clubId: Long, surveys: List<JoinSurveyRequest>): List<JoinSurvey> {

        return clubSurveyRepository.saveAll(surveys.map {
            ClubJoinSurveyEntity(
                    it.sequence,
                    it.question, clubId
            )
        }).map(::toSurvey)
    }

    fun toSurvey(surveyEntity: ClubJoinSurveyEntity): JoinSurvey {
        return JoinSurvey(
                surveyEntity.id!!,
                surveyEntity.clubId,
                surveyEntity.sequence,
                surveyEntity.question
        )
    }
}