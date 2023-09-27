package org.cloudnovel.novel.core.domain.user

data class UserCreateRequest(
        val account:String,
        val password:String
) {

    fun hello():String  {
        return account + password

    }
}