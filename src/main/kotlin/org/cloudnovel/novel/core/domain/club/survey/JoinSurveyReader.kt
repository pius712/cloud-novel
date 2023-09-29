package org.cloudnovel.novel.core.domain.club.survey

import org.cloudnovel.novel.core.storage.club.ClubJoinSurveyEntity
import org.cloudnovel.novel.core.storage.club.ClubSurveyRepository
import org.springframework.stereotype.Component

@Component
class JoinSurveyReader(private val repository: ClubSurveyRepository) {


    fun readByClub(clubId: Long): List<JoinSurvey> {

        return repository.findByClubId(clubId).map(::toJoinSurvey)
    }

    fun toJoinSurvey(joinSurveyEntity: ClubJoinSurveyEntity): JoinSurvey {
        return JoinSurvey(
                joinSurveyEntity.id!!,
                joinSurveyEntity.clubId,
                joinSurveyEntity.sequence,
                joinSurveyEntity.question
        )
    }


}