package org.cloudnovel.novel.core.domain.novel.contents

import org.springframework.stereotype.Service

@Service
class NovelContentsReadService(private val novelContentsReader: NovelContentsReader) {

    fun getNovel(id: Long): NovelContents {
        return novelContentsReader.readById(id);
    }
}