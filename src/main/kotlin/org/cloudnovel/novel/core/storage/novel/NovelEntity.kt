package org.cloudnovel.novel.core.storage.novel

import jakarta.persistence.*
import org.cloudnovel.novel.core.common.enum.CommentRestrictionStatus
import org.cloudnovel.novel.core.common.enum.NovelVisibilityStatus
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@EntityListeners(NovelChangeListener::class)
@Table(name = "novel")
class NovelEntity(
        @Column
        val title: String,
        @Column
        var contents: String,

        @Column(name = "ref_profile_id")
        var lastModifierId: Long,

        @Enumerated(EnumType.STRING)
        var commentRestrictionStatus: CommentRestrictionStatus,
        @Enumerated(EnumType.STRING)
        var visibilityStatus: NovelVisibilityStatus

) : BaseEntity()