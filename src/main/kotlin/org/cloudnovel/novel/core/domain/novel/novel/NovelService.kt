package org.cloudnovel.novel.core.domain.novel.novel

import org.cloudnovel.novel.core.common.enum.CommentRestrictionStatus
import org.cloudnovel.novel.core.common.enum.NovelVisibilityStatus
import org.springframework.stereotype.Service


@Service
class NovelService(
        private val novelReader: NovelReader,
        private val novelWriter: NovelWriter,
        private val novelValidator: NovelValidator
) {

    fun register(profileId: Long, novelCreateRequest: NovelCreateRequest): Long {
        val id = novelWriter.create(profileId, novelCreateRequest)
        println(id);
        return id;
    }

    fun append(id: Long, appendNovelRequest: AppendNovelRequest): Long {

        val prevNovel = novelReader.readById(id);
        novelValidator.assertStartWithOriginalContent(prevNovel.body, appendNovelRequest.body)

        return novelWriter.appendBody(id, appendNovelRequest)
    }

    fun restrictComment(novelId: Long): Long {
        return novelWriter.updateRestriction(novelId, CommentRestrictionStatus.RESTRICTED)
    }

    fun allowComment(novelId: Long): Long {
        return novelWriter.updateRestriction(novelId, CommentRestrictionStatus.ALLOWED)
    }

    fun convertToInvisible(novelId: Long): Long {
        return novelWriter.updateVisibility(novelId, NovelVisibilityStatus.INVISIBLE)
    }

    fun convertVisible(novelId: Long): Long {
        return novelWriter.updateVisibility(novelId, NovelVisibilityStatus.VISIBLE);
    }
}