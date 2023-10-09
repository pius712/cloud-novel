package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.domain.novel.novel.NovelCreateRequest
import org.springframework.lang.NonNull

data class CreateNovelRequestDto(
        @NonNull val title: String,
        @NonNull val body: String
) {

    fun toRequest(): NovelCreateRequest {
        return NovelCreateRequest(title, body);
    }
}