package org.cloudnovel.novel.core.domain.novel.contents

import org.cloudnovel.novel.core.common.enum.CommentRestrictionStatus
import org.cloudnovel.novel.core.common.enum.NovelVisibilityStatus
import org.springframework.stereotype.Service


@Service
class NovelContentsService(
        private val novelContentsReader: NovelContentsReader,
        private val novelContentsWriter: NovelContentsWriter,
        private val novelValidator: NovelValidator
) {

    fun register(novelCreateRequest: NovelCreateRequest): Long {
        val id = novelContentsWriter.create(novelCreateRequest)
        println(id);
        return id;
    }

    fun append(id: Long, appendNovelRequest: AppendNovelRequest): Long {

        val prevNovel = novelContentsReader.readById(id);
        novelValidator.assertStartWithOriginalContent(prevNovel.body, appendNovelRequest.body)

        return novelContentsWriter.appendBody(id, appendNovelRequest)
    }

    fun restrictComment(novelId: Long): Long {
        return novelContentsWriter.updateRestriction(novelId, CommentRestrictionStatus.RESTRICTED)
    }

    fun allowComment(novelId: Long): Long {
        return novelContentsWriter.updateRestriction(novelId, CommentRestrictionStatus.ALLOWED)
    }

    fun convertToInvisible(novelId: Long): Long {
        return novelContentsWriter.updateVisibility(novelId, NovelVisibilityStatus.INVISIBLE)
    }

    fun convertVisible(novelId: Long): Long {
        return novelContentsWriter.updateVisibility(novelId, NovelVisibilityStatus.VISIBLE);
    }
}