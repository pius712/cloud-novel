package org.cloudnovel.novel.core.storage.club

import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
data class SurveyAnswerEntity(
        @Column(name = "ref_survey_id")
        val surveyId: Long,

        @Column(name = "ref_profile_id")
        val profileId: Long,

        @Column
        val answer: String
) : BaseEntity() {

}