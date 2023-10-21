package org.cloudnovel.novel.core.controller.admin.response

import org.cloudnovel.novel.core.domain.Interest.Interest

data class InterestResponseDto(
        val id: Long,
        val name: String,
        val category: String,
) {
    constructor(interest: Interest) : this(interest.id, interest.name, interest.category)
}
