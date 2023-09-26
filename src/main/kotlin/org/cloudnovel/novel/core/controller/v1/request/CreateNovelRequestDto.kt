package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.domain.novel.CreateNovelRequest

data class CreateNovelRequestDto(
        val title:String,
        val body:String
) {

    fun toRequest():CreateNovelRequest {
        return CreateNovelRequest(title, body);
    }
}