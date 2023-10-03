package org.cloudnovel.novel.core.storage.comment

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<CommentEntity, Long> {

    fun findByNovelId(novelId: Long): List<CommentEntity>

    fun findByProfileId(profileId: Long): List<CommentEntity>
}