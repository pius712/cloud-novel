package org.cloudnovel.novel.core.domain.novel.novel

import org.springframework.stereotype.Service

@Service
class NovelReadService(private val novelReader: NovelReader) {

    fun getNovel(id: Long): Novel {
        return novelReader.readById(id);
    }
}