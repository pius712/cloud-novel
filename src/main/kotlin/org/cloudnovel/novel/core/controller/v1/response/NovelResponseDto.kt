package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.novel.contents.NovelContents

data class NovelResponseDto(
        val id: Long,
        val title: String,
        val body: String
) {

    constructor(novelContents: NovelContents) : this(novelContents.id, novelContents.title, novelContents.body)
}