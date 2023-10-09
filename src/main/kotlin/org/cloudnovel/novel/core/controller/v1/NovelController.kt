package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.AppendNovelRequestDto
import org.cloudnovel.novel.core.controller.v1.request.CreateNovelRequestDto
import org.cloudnovel.novel.core.controller.v1.response.NovelWithCommentResponseDto
import org.cloudnovel.novel.core.domain.novel.comment.CommentService
import org.cloudnovel.novel.core.domain.novel.novel.NovelReadService
import org.cloudnovel.novel.core.domain.novel.novel.NovelService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/novel")
class NovelController(
        private val novelService: NovelService,
        private val novelReadService: NovelReadService,
        private val commentService: CommentService
) {

    @PostMapping()
    fun register(@RequestBody createNovelRequestDto: CreateNovelRequestDto): ApiResponse<Long> {
        return ApiResponse.ok(novelService.register(
                createNovelRequestDto.toRequest())
        )
    }

    @GetMapping("{id}")
    fun getNovel(@PathVariable id: Long): ApiResponse<NovelWithCommentResponseDto> {
        val novel = novelReadService.getNovel(id)
        val comments = commentService.getNovelComment(id)
        return ApiResponse.ok(NovelWithCommentResponseDto(novel, comments))
    }

    @PostMapping("{id}/append")
    fun append(
            @PathVariable id: Long,
            @RequestBody appendRequestDto: AppendNovelRequestDto): ApiResponse<Long> {
        return ApiResponse.ok(novelService.append(id, appendRequestDto.toAppendNovelRequest()))
    }

    @PostMapping("{id}/visibility/invisible")
    fun changeInvisible(
            @PathVariable id: Long,
    ): ApiResponse<Long> {
        val result = novelService.convertToInvisible(id)
        return ApiResponse.ok(result);
    }

    @PostMapping("{id}/visibility/visible")
    fun changeVisible(
            @PathVariable id: Long,
    ): ApiResponse<Long> {
        val result = novelService.convertVisible(id)
        return ApiResponse.ok(result);
    }

    @PostMapping("{id}/comment/restrict")
    fun restrictComment(
            @PathVariable id: Long,
    ): ApiResponse<Long> {
        val result = novelService.restrictComment(id);
        return ApiResponse.ok(result)
    }

    @PostMapping("{id}/comment/allow")
    fun allowComment(
            @PathVariable id: Long,
    ): ApiResponse<Long> {
        val result = novelService.allowComment(id);
        return ApiResponse.ok(result)
    }
}