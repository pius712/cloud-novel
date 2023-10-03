package org.cloudnovel.novel.core.domain.novel.contents

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.common.enum.CommentRestrictionStatus
import org.cloudnovel.novel.core.common.enum.NovelVisibilityStatus
import org.cloudnovel.novel.core.storage.novel.NovelEntity
import org.cloudnovel.novel.core.storage.novel.NovelRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
@Transactional
class NovelContentsWriter(private val novelRepository: NovelRepository) {

    fun create(novelCreateRequest: NovelCreateRequest): Long {
        return novelRepository.save(
                NovelEntity(
                        novelCreateRequest.title,
                        novelCreateRequest.body,
                        CommentRestrictionStatus.ALLOWED,
                        NovelVisibilityStatus.VISIBLE,
                )
        ).id!!
    }

    fun appendBody(id: Long, appendNovelRequest: AppendNovelRequest): Long {

        val found = novelRepository.findByIdOrNull(id)?.let {
            it.contents = appendNovelRequest.body
            it;
        } ?: throw RuntimeException()
        return found.id!!

    }

    fun updateRestriction(novelId: Long, restrictionStatus: CommentRestrictionStatus): Long {
        val found = novelRepository.findByIdOrNull(novelId)?.let {
            it.commentRestrictionStatus = restrictionStatus
            it
        } ?: throw CoreApiException(CoreExceptionType.NOVEL_NOT_FOUND)
        return found.id!!
    }

    fun updateVisibility(novelId: Long, visibilityStatus: NovelVisibilityStatus): Long {
        val found = novelRepository.findByIdOrNull(novelId)?.let {
            it.visibilityStatus = visibilityStatus
            it
        } ?: throw CoreApiException(CoreExceptionType.NOVEL_NOT_FOUND)

        return found.id!!
    }

}