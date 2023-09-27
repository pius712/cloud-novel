package org.cloudnovel.novel.core.domain.user

import org.springframework.stereotype.Service


@Service
class UserService(private val userReader:UserReader,
        private val userWriter:UserWriter) {


    fun signUp(userCreateRequest: UserCreateRequest) :Long {
        return userWriter.write(userCreateRequest)
    }


}