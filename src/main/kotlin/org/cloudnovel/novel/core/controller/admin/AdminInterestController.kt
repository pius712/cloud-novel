package org.cloudnovel.novel.core.controller.admin

import org.cloudnovel.novel.core.controller.admin.request.CreateInterestRequestDto
import org.cloudnovel.novel.core.controller.admin.response.InterestListResponseDto
import org.cloudnovel.novel.core.domain.Interest.CreateInterestRequest
import org.cloudnovel.novel.core.domain.Interest.InterestReadService
import org.cloudnovel.novel.core.domain.Interest.InterestWriteService
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/v1/interest")
class AdminInterestController(private val interestReadService: InterestReadService,
                              private val interestWriteService: InterestWriteService) {


    @GetMapping("/list")
    fun getAllInterest(): ApiResponse<InterestListResponseDto> {

        val interests = interestReadService.getInterests()

        return ApiResponse.ok(InterestListResponseDto.of(interests))
    }

    @PostMapping("/new")
    fun createInterest(@RequestBody createRequest: CreateInterestRequestDto): ApiResponse<Any> {
        interestWriteService.createInterest(CreateInterestRequest(createRequest.category, createRequest.name))
        return ApiResponse.ok()
    }
}