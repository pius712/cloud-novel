package org.cloudnovel.novel.core.support.error

import org.springframework.http.HttpStatus

enum class ServiceExceptionType(
        override val status: HttpStatus,
        override val code: ErrorCode,
        override val message: String) : BaseExceptionType {

    NOT_FOUND_PROFILE_ID(HttpStatus.BAD_REQUEST, ErrorCode.NOT_FOUND_PROFILE_ID, "프로필 아이디가 존재하지 않습니다."),
    NOT_FOUND_USER_ID(HttpStatus.BAD_REQUEST, ErrorCode.NOT_FOUND_USER_ID, "유저 아이디가 존재하지 않습니다.")
}