package org.cloudnovel.novel.core.storage.comment

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity


@Entity
@Table(name = "comment")
class CommentEntity(
        @Column(name = "ref_novel_id")
        val novelId: Long,

        @Column(name = "ref_profile_id")
        val profileId: Long,


        @Column
        val body: String
) : BaseEntity() {
}