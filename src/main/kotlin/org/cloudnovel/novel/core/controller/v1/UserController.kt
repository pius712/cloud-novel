package org.cloudnovel.novel.core.controller.v1

import org.cloudnovel.novel.core.controller.v1.request.CreateUserRequestDto
import org.cloudnovel.novel.core.domain.user.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/user")
class UserController(private val userService: UserService) {
    @PostMapping
    fun signUp(
            @RequestBody createUserRequestDto: CreateUserRequestDto,
    ):Long  {
        return userService.signUp(createUserRequestDto.toRequest());
    }
}

