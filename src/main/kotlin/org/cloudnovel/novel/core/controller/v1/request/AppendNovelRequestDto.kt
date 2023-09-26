package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.domain.novel.AppendNovelRequest

data class AppendNovelRequestDto (
        val body:String
){

    fun toAppendNovelRequest():AppendNovelRequest {
       return AppendNovelRequest(body)
    }
}