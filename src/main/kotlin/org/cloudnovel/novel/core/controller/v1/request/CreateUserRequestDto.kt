package org.cloudnovel.novel.core.controller.v1.request

import org.cloudnovel.novel.core.domain.user.UserCreateRequest

data class CreateUserRequestDto(val id:String, val password:String) {

    fun toRequest():UserCreateRequest  {
        return UserCreateRequest(id, password)
    }
}