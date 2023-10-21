package org.cloudnovel.novel.core.controller.admin.response

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


