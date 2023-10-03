package org.cloudnovel.novel.core.storage.club

import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
data class ClubSurveyAnswerEntity(
        @Column(name = "ref_question_id")
        val questionId: Long,

        @Column(name = "ref_club_member_id")
        val clubMemberId: Long,

        @Column
        val answer: String
) : BaseEntity() {

}