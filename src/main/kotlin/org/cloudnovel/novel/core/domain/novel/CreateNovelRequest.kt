package org.cloudnovel.novel.core.domain.novel

data class CreateNovelRequest(
        val title:String,
        val body:String,
) {
}