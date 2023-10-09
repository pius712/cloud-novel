package org.cloudnovel.novel.core.storage.profile

import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity


@Entity
@Table(name = "follow", indexes = [
    Index(columnList = "followerId"),
    Index(columnList = "followingId"),
    Index(columnList = "followingId, followerId", unique = true)
])
data class FollowEntity(
        val followerId: Long,
        val followingId: Long
) : BaseEntity() {
}