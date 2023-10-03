package org.cloudnovel.novel.core.domain.novel.contents

data class NovelCreateRequest(
        val title: String,
        val body: String,
) {
}