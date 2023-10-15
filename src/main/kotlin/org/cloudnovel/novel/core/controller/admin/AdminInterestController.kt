package org.cloudnovel.novel.core.controller.admin

import org.cloudnovel.novel.core.domain.Interest.InterestReadService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/admin/interest")
class AdminInterestController(private val interestReadService: InterestReadService) {


}