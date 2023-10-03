package org.cloudnovel.novel.core.domain.novel

import org.springframework.stereotype.Service


@Service
class NovelReadService(private val novelReader: NovelReader) {


    fun getNovel(novelId: Long): Novel {
        return novelReader.readById(novelId)
    }
}