package org.cloudnovel.novel.core.domain.comment

import org.springframework.stereotype.Service

@Service
class CommentService(private val commentReader: CommentReader,
                     private val commentWriter: CommentWriter) {
    
    fun getNovelComment(novelId: Long): List<Comment> {
        return commentReader.readByNovel(novelId)
    }

    fun getUserComment(profileId: Long): List<Comment> {
        return commentReader.readByProfile(profileId)
    }

    fun writeComment(novelId: Long, profileId: Long, comment: String): Long {
        return commentWriter.write(novelId, profileId, comment)
    }
}