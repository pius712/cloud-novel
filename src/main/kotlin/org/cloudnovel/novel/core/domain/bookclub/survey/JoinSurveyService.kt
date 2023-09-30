package org.cloudnovel.novel.core.domain.bookclub.survey

import org.springframework.stereotype.Service

@Service
class JoinSurveyService(
        private val joinSurveyReader: JoinSurveyReader,
        private val joinSurveyWriter: JoinSurveyWriter) {


    fun getSurveys(clubId: Long): List<JoinSurveyQuestion> {
        return joinSurveyReader.readByClub(clubId)
    }

    fun register(id: Long, joinSurveyRequests: List<JoinSurveyRequest>): List<JoinSurveyQuestion> {
        return joinSurveyWriter.prepareSurvey(id, joinSurveyRequests)
    }


}