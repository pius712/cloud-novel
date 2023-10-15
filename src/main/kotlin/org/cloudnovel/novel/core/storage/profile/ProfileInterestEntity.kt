package org.cloudnovel.novel.core.storage.profile

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "profile_interest")
data class ProfileInterestEntity(
        @Column(name = "ref_profile_id")
        val profileId: Long,
        @Column(name = "ref_interest_id")
        val interestId: Long,
) : BaseEntity()
