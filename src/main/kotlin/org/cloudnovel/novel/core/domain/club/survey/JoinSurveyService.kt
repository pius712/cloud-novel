package org.cloudnovel.novel.core.domain.club.survey

import org.springframework.stereotype.Service

@Service
class JoinSurveyService(
        private val joinSurveyReader: JoinSurveyReader,
        private val joinSurveyWriter: JoinSurveyWriter) {


    fun getSurveys(clubId: Long): List<JoinSurvey> {
        return joinSurveyReader.readByClub(clubId)
    }

    fun register(id: Long, joinSurveyRequests: List<JoinSurveyRequest>): List<JoinSurvey> {
        return joinSurveyWriter.prepareSurvey(id, joinSurveyRequests)
    }

}