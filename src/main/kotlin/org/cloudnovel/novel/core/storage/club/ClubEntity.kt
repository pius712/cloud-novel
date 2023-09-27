package org.cloudnovel.novel.core.storage.club

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "club")
class ClubEntity(
        @Column
        var name: String,
        @Column
        var description: String,
) : BaseEntity() {
}