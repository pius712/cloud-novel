package org.cloudnovel.novel.core.storage.novel

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "novel_history_entity")
data class NovelHistoryEntity(
        @Column(name = "ref_modifier_id")
        val modifierId: Long,
        @Column
        val previousContents: String,
        @Column
        val currentContents: String,
) : BaseEntity()
