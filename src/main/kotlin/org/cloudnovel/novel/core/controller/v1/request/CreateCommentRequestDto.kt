package org.cloudnovel.novel.core.controller.v1.request

data class CreateCommentRequestDto(
        val profileId: Long,
        val body: String)
