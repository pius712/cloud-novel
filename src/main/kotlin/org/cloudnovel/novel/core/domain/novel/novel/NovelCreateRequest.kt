package org.cloudnovel.novel.core.domain.novel.novel

data class NovelCreateRequest(
        val title: String,
        val body: String,
) {
}