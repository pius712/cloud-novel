package org.cloudnovel.novel.core.domain.novel.comment

import org.cloudnovel.novel.core.storage.comment.CommentEntity
import org.cloudnovel.novel.core.storage.comment.CommentRepository
import org.cloudnovel.novel.core.storage.novel.NovelRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

/**
 * novel package 에서 읽어오면, package간에 의존성이 생김
 * */
@Component
class CommentWriter(
        private val novelRepository: NovelRepository,
        private val commentRepository: CommentRepository) {
    fun write(novelId: Long, profileId: Long, comment: String): Long {
        assertNovel(novelId)

        return commentRepository.save(CommentEntity(
                novelId,
                profileId,
                comment
        )).id!!
    }

    private fun assertNovel(novelId: Long) {
        novelRepository.findByIdOrNull(novelId) ?: throw CoreApiException(CoreExceptionType.NOVEL_NOT_FOUND);
    }
}