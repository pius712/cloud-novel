package org.cloudnovel.novel.core.storage.club

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "club_join_survey")
class ClubJoinSurveyEntity(
        @Column
        val question: String,
        @Column(name = "ref_club_id")
        val clubId: Long
) : BaseEntity() {


}