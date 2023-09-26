package org.cloudnovel.novel.core.domain.novel

import org.springframework.stereotype.Service


@Service
class NovelService(
        private val novelReader: NovelReader
) {

    fun getNovel(id:Long) {
        novelReader.readBy(id);

    }
}