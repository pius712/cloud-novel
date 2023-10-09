package org.cloudnovel.novel.core.storage.profile

import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "follower", indexes = [
    Index(columnList = "profileId"),
    Index(columnList = "followerId")
])
data class FollowerEntity(
        val profileId: Long,
        val followerId: Long
) : BaseEntity() {
}