package org.cloudnovel.novel.core.domain.user

import org.cloudnovel.novel.core.storage.user.UserEntity
import org.cloudnovel.novel.core.storage.user.UserRepository
import org.springframework.stereotype.Component

@Component
class UserWriter(private val userRepository: UserRepository){


    fun write(userCreateRequest: UserCreateRequest):Long {
        return userRepository.save(
                UserEntity(userCreateRequest.account, userCreateRequest.password)
        ).id!!
    }

}