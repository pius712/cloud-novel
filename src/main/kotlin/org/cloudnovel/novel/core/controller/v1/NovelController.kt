package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.AppendNovelRequestDto
import org.cloudnovel.novel.core.controller.v1.request.CreateNovelRequestDto
import org.cloudnovel.novel.core.controller.v1.response.NovelResponseDto
import org.cloudnovel.novel.core.domain.novel.Novel
import org.cloudnovel.novel.core.domain.novel.NovelService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/novel")
class NovelController(
        private val novelService: NovelService,
) {


    @PostMapping()
    fun register(@RequestBody createNovelRequestDto: CreateNovelRequestDto):Long {
        return novelService.register(
                createNovelRequestDto.toRequest()
        )
    }

    @GetMapping("{id}")
    fun getNovel(@PathVariable id: Long):NovelResponseDto {
         return NovelResponseDto(novelService.getNovel(id));
    }

    @PostMapping("{id}/append")
    fun append(
            @PathVariable id:Long,
            @RequestBody appendRequestDto: AppendNovelRequestDto):Long {
        return novelService.append(id,appendRequestDto.toAppendNovelRequest())
    }

}