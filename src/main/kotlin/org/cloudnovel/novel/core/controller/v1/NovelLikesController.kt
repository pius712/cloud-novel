package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.CreateNovelLikeRequestDto
import org.cloudnovel.novel.core.domain.novel.likes.NovelLiker
import org.cloudnovel.novel.core.domain.novel.likes.NovelLikesService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/novel/{novelId}/likes")
class NovelLikesController(private val novelLikesService: NovelLikesService) {


    @GetMapping
    fun getLiker(@PathVariable novelId: Long): ApiResponse<List<NovelLiker>> {
        val likers = novelLikesService.getLiker(novelId)

        return ApiResponse.ok(likers)
    }


    @PostMapping
    fun likesNovel(@PathVariable novelId: Long, @RequestBody createLikeRequestDto: CreateNovelLikeRequestDto): ApiResponse<Long> {
        val id = novelLikesService.likesNovel(novelId, createLikeRequestDto.profileId)
        
        return ApiResponse.ok(id)
    }
}