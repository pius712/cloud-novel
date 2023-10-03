package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.common.enum.NovelVisibilityStatus

data class UpdateNovelVisibilityRequestDto(
        val visibility: NovelVisibilityStatus
)
