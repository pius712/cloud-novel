package org.cloudnovel.novel.core.storage.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "users")
class UserEntity(
        @Column
        val account: String,
        @Column
        val password: String
) : BaseEntity() {
}