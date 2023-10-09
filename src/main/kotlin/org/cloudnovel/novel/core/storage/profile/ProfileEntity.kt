package org.cloudnovel.novel.core.storage.profile

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "profile")
class ProfileEntity(
        val nickname: String,
        var bio: String,
        val userId: Long,

        ) : BaseEntity() {
}