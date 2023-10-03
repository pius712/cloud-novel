package org.cloudnovel.novel.core.domain.comment

import org.cloudnovel.novel.core.storage.comment.CommentEntity
import org.cloudnovel.novel.core.storage.comment.CommentRepository
import org.springframework.stereotype.Component

@Component
class CommentWriter(private val commentRepository: CommentRepository) {
    fun write(novelId: Long, profileId: Long, comment: String): Long {
        return commentRepository.save(CommentEntity(
                novelId,
                profileId,
                comment
        )).id!!
    }
}