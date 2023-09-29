package org.cloudnovel.novel.core.support.error

import org.springframework.http.HttpStatus

enum class CoreExceptionType(
        override val status: HttpStatus,
        override val code: ErrorCode,
        override val message: String,
) : BaseExceptionType {

    PROFILE_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.PROFILE_NOT_FOUND_ERROR, "profile 이 없습니다.");
}