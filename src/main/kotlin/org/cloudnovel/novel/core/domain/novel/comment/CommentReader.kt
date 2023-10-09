package org.cloudnovel.novel.core.domain.novel.comment

import org.cloudnovel.novel.core.domain.profile.profile.Profile
import org.cloudnovel.novel.core.domain.profile.profile.ProfileReader
import org.cloudnovel.novel.core.storage.comment.CommentEntity
import org.cloudnovel.novel.core.storage.comment.CommentRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.stereotype.Component

@Component
class CommentReader(
        private val commentRepository: CommentRepository,
        private val profileReader: ProfileReader) {

    fun readByNovel(novelId: Long): List<Comment> {
        val commentEntities = commentRepository.findByNovelId(novelId)
        val profileMap = profileReader.readByIdIn(commentEntities.map { it.profileId }).groupBy { it.id }

        return commentEntities.map {
            toComment(it, profileMap[it.profileId]?.firstOrNull()
                    ?: throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND))
        }
    }

    fun readByProfile(profileId: Long): List<Comment> {
        val commentEntities = commentRepository.findByProfileId(profileId);
        val profileMap = profileReader.readByIdIn(commentEntities.map { it.profileId }).groupBy { it.id }

        return commentEntities.map {
            toComment(it, profileMap[it.profileId]?.firstOrNull()
                    ?: throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND))
        }
    }

    fun toComment(commentEntity: CommentEntity, profile: Profile): Comment {
        return Comment(commentEntity.id!!, profile.nickname, commentEntity.body)
    }
}