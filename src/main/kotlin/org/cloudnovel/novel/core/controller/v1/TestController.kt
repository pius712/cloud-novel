package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.domain.serviceUser.ServiceUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/test")
class TestController {


    @GetMapping
    fun test(serviceUser: ServiceUser): ServiceUser {
        return serviceUser;
    }
}