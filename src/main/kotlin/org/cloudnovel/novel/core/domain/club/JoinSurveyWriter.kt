package org.cloudnovel.novel.core.domain.club

import org.cloudnovel.novel.core.storage.club.ClubJoinSurveyEntity
import org.cloudnovel.novel.core.storage.club.ClubSurveyRepository
import org.springframework.stereotype.Component

@Component
class ClubJoinSurveyWriter(private val clubSurveyRepository: ClubSurveyRepository) {

    fun prepareSurvey(clubId: Long, surveys: List<ClubJoinSurveyRequest>): List<JoinSurvey> {

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