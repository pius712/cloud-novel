package org.cloudnovel.novel.core.storage.profile

import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "following", indexes = [
    Index(columnList = "profileId"),
    Index(columnList = "followingId")
])
data class FollowingEntity(
        val profileId: Long,
        val followingId: Long
) : BaseEntity() {
}