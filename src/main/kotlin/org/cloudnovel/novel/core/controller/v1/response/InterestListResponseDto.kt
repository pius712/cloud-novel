package org.cloudnovel.novel.core.controller.v1.response

import org.cloudnovel.novel.core.domain.Interest.Interest

data class InterestListResponseDto(
        val interests: List<InterestResponseDto>
) {

    companion object {
        fun of(interests: List<Interest>): InterestListResponseDto {
            return InterestListResponseDto(interests.map(::InterestResponseDto))
        }
    }
}
