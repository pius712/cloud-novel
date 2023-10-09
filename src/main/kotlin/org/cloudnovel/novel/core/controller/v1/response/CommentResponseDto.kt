package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.novel.comment.Comment


data class CommentResponseDto(
        val id: Long,
        val nickname: String,
        val body: String
) {

    constructor(comment: Comment) : this(comment.id, comment.writer, comment.body)
}
