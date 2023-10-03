package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.AppendNovelRequestDto
import org.cloudnovel.novel.core.controller.v1.request.CreateNovelRequestDto
import org.cloudnovel.novel.core.domain.novel.Novel
import org.cloudnovel.novel.core.domain.novel.NovelReadService
import org.cloudnovel.novel.core.domain.novel.contents.NovelContentsReadService
import org.cloudnovel.novel.core.domain.novel.contents.NovelContentsService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/novel")
class NovelController(
        private val novelContentsService: NovelContentsService,
        private val novelContentsReadService: NovelContentsReadService,
        private val novelReadService: NovelReadService
) {

    @PostMapping()
    fun register(@RequestBody createNovelRequestDto: CreateNovelRequestDto): ApiResponse<Long> {
        return ApiResponse.ok(novelContentsService.register(
                createNovelRequestDto.toRequest())
        )
    }

    @GetMapping("{id}")
    fun getNovel(@PathVariable id: Long): ApiResponse<Novel> {
        return ApiResponse.ok(novelReadService.getNovel(id));
    }

    @PostMapping("{id}/append")
    fun append(
            @PathVariable id: Long,
            @RequestBody appendRequestDto: AppendNovelRequestDto): ApiResponse<Long> {
        return ApiResponse.ok(novelContentsService.append(id, appendRequestDto.toAppendNovelRequest()))
    }

    @PostMapping("{id}/visibility/invisible")
    fun changeInvisible(
            @PathVariable id: Long,
    ): ApiResponse<Long> {
        val result = novelContentsService.convertToInvisible(id)
        return ApiResponse.ok(result);
    }

    @PostMapping("{id}/visibility/visible")
    fun changeVisible(
            @PathVariable id: Long,
    ): ApiResponse<Long> {
        val result = novelContentsService.convertVisible(id)
        return ApiResponse.ok(result);
    }

    @PostMapping("{id}/comment/restrict")
    fun restrictComment(
            @PathVariable id: Long,
    ): ApiResponse<Long> {
        val result = novelContentsService.restrictComment(id);
        return ApiResponse.ok(result)
    }

    @PostMapping("{id}/comment/allow")
    fun allowComment(
            @PathVariable id: Long,
    ): ApiResponse<Long> {
        val result = novelContentsService.allowComment(id);
        return ApiResponse.ok(result)
    }
}