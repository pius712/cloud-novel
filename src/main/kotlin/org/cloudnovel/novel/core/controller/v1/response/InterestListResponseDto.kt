package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.Interest.Interest

data class InterestListResponseDto(
        val interests: List<InterestResponseDto>
) {

    constructor(interests: List<Interest>) : this(interests.map(::InterestResponseDto))
}
