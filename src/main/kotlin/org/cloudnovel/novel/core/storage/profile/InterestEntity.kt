package org.cloudnovel.novel.core.storage.profile

import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity()
@Table(name = "interest")
data class InterestEntity(
        var category: String,
        var name: String,
) : BaseEntity()
