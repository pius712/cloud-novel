package org.cloudnovel.novel.core.storage.likes

import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity


@Entity
@Table(name = "novel_likes")
data class NovelLikesEntity(
        val novelId: Long,
        val profileId: Long,
) : BaseEntity()
