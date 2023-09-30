package org.cloudnovel.novel.core.storage.club

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

// TODO: 순서 관리는 어떻게 하지? 삭제하면 순서가 어긋날 수 있을듯?
@Entity
@Table(name = "club_join_survey")
class ClubJoinSurveyQuestionEntity(
        @Column(name = "ref_club_id")
        val clubId: Long,

        @Column
        val sequence: Long,
        @Column
        val question: String,
) : BaseEntity()