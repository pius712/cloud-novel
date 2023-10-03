package org.cloudnovel.novel.core.domain.novel

import org.cloudnovel.novel.core.domain.novel.comment.Comment
import org.cloudnovel.novel.core.storage.comment.CommentEntity
import org.cloudnovel.novel.core.storage.comment.CommentRepository
import org.cloudnovel.novel.core.storage.novel.NovelEntity
import org.cloudnovel.novel.core.storage.novel.NovelRepository
import org.cloudnovel.novel.core.storage.profile.ProfileEntity
import org.cloudnovel.novel.core.storage.profile.ProfileRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class NovelReader(
        private val novelRepository: NovelRepository,
        private val novelCommentRepository: CommentRepository,
        private val profileRepository: ProfileRepository) {


    fun readById(novelId: Long): Novel {
        val found = novelRepository.findByIdOrNull(novelId) ?: throw CoreApiException(CoreExceptionType.NOVEL_NOT_FOUND)
        val commentEntities = novelCommentRepository.findByNovelId(found.id!!)
        val profileEntityMap = profileRepository.findByIdIn(commentEntities.map { it.profileId }).groupBy { it.id }
        val comments = commentEntities.map { toComment(it, profileEntityMap[it.id!!]!!) }

        return toNovel(found, comments)
    }


    private fun toNovel(novelEntity: NovelEntity, comments: List<Comment>): Novel {
        return Novel(
                novelEntity.id!!,
                novelEntity.title,
                novelEntity.contents,
                comments
        )
    }


    private fun toComment(it: CommentEntity, profileEntities: List<ProfileEntity>): Comment {
        val profileEntity = profileEntities.firstOrNull() ?: throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND)
        return Comment(
                it.id!!,
                profileEntity.nickname,
                it.body,
        )
    }

}