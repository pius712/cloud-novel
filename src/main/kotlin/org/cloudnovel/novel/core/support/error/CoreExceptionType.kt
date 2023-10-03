package org.cloudnovel.novel.core.support.error

import org.springframework.http.HttpStatus

enum class CoreExceptionType(
        override val status: HttpStatus,
        override val code: ErrorCode,
        override val message: String,
) : BaseExceptionType {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.USER_NOT_FOUND_ERROR, "유저를 찾을 수 없습니다."),
    PROFILE_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.PROFILE_NOT_FOUND_ERROR, "profile 이 없습니다."),

    NOVEL_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.NOVEL_NOT_FOUND_ERROR, "해당 소설을 찾을 수 없습니다."),

    SURVEY_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.SURVEY_NOT_FOUND_ERROR, "북클럽을 열기 위해서는 가입 설문이 필요합니다."),

    ALREADY_JOINED(HttpStatus.OK, ErrorCode.ALREADY_JOINED_ERROR, "이미 가입하셨습니다.")
}