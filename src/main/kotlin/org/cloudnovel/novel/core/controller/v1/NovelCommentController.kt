package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.CreateCommentRequestDto
import org.cloudnovel.novel.core.domain.novel.comment.Comment
import org.cloudnovel.novel.core.domain.novel.comment.CommentService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/novel/{novelId}/comment")
class NovelCommentController(private val commentService: CommentService) {


    @GetMapping
    fun getComments(@PathVariable novelId: Long): ApiResponse<List<Comment>> {
        val result = commentService.getNovelComment(novelId)

        return ApiResponse.ok(result)
    }

    @PostMapping
    fun writeComment(@PathVariable novelId: Long, @RequestBody createCommentRequestDto: CreateCommentRequestDto): ApiResponse<Long> {
        val result = commentService.writeComment(novelId, createCommentRequestDto.profileId, createCommentRequestDto.body)

        return ApiResponse.ok(result)
    }
}