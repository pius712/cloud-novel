package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.novel.Novel

data class NovelResponseDto(
        val id:Long,
        val title:String,
        val body:String
) {

    constructor(novel: Novel) : this(novel.id, novel.title, novel.body)
}