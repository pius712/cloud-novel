package org.cloudnovel.novel.core.support.error

import org.springframework.http.HttpStatus

enum class GlobalExceptionType(
        override val status: HttpStatus,
        override val code: ErrorCode,
        override val message: String,
) : BaseExceptionType {

    NO_HANDLER_FOUND(HttpStatus.NOT_FOUND, ErrorCode.NO_HANDLER_FOUND_ERROR, "매칭되는 핸들러가 없습니다.")

}