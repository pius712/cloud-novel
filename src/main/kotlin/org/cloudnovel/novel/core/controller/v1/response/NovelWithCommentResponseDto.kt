package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.novel.comment.Comment
import org.cloudnovel.novel.core.domain.novel.novel.Novel

data class NovelWithCommentResponseDto(
        val id: Long,
        val title: String,
        val body: String,
        val comments: List<CommentResponseDto>
) {

    constructor(novel: Novel, comments: List<Comment>) : this(novel.id, novel.title, novel.body, comments.map(::CommentResponseDto))
}