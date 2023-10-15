package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.Interest.Interest

data class InterestResponseDto(
        val id: Long,
        val category: String,
        val name: String,
) {
    constructor(interest: Interest) : this(interest.id, interest.category, interest.name)
}
