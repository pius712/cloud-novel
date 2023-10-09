package org.cloudnovel.novel.core.domain.novel.comment

import org.cloudnovel.novel.core.domain.profile.profile.UserProfile
import org.cloudnovel.novel.core.domain.profile.profile.UserProfileReader
import org.cloudnovel.novel.core.storage.comment.CommentEntity
import org.cloudnovel.novel.core.storage.comment.CommentRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.stereotype.Component

@Component
class CommentReader(
        private val commentRepository: CommentRepository,
        private val userProfileReader: UserProfileReader) {

    fun readByNovel(novelId: Long): List<Comment> {
        val commentEntities = commentRepository.findByNovelId(novelId)
        val profileMap = userProfileReader.readAllById(commentEntities.map { it.profileId }).groupBy { it.id }

        return commentEntities.map {
            toComment(it, profileMap[it.profileId]?.firstOrNull()
                    ?: throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND))
        }
    }

    fun readByProfile(profileId: Long): List<Comment> {
        val commentEntities = commentRepository.findByProfileId(profileId);
        val profileMap = userProfileReader.readAllById(commentEntities.map { it.profileId }).groupBy { it.id }

        return commentEntities.map {
            toComment(it, profileMap[it.profileId]?.firstOrNull()
                    ?: throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND))
        }
    }

    fun toComment(commentEntity: CommentEntity, userProfile: UserProfile): Comment {
        return Comment(commentEntity.id!!, userProfile.nickname, commentEntity.body)
    }
}