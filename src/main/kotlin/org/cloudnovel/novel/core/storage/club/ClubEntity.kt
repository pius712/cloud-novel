package org.cloudnovel.novel.core.storage.club

import jakarta.persistence.*
import org.cloudnovel.novel.core.common.enum.ClubRecruitStatus
import org.cloudnovel.novel.core.common.enum.ClubVisibilityStatus
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "club")
class ClubEntity(

        @Column(name = "ref_profile_id")
        val profileId: Long,
        @Column
        var name: String,
        @Column
        var description: String,

        @Enumerated(EnumType.STRING)
        var recruitStatus: ClubRecruitStatus,

        @Enumerated(EnumType.STRING)
        var visibilityStatus: ClubVisibilityStatus,
) : BaseEntity() {
}