package org.cloudnovel.novel.core.storage.club

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "club_participant")
data class ClubParticipantEntity(
        @Column(name = "ref_club_id")
        val clubId: Long,
        @Column(name = "ref_profile_id")
        val profileId: Long
) : BaseEntity()
