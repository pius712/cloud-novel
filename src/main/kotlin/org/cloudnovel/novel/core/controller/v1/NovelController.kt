package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.domain.novel.NovelService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/novel")
class NovelController(
        private val novelService: NovelService,
) {


    @GetMapping(":id")
    fun getNovel(@PathVariable id:Long) {
        return novelService.getNovel(id);
    }
}