package org.cloudnovel.novel.core.support.error

import org.springframework.http.HttpStatus

enum class CoreExceptionType(
        override val status: HttpStatus,
        override val code: ErrorCode,
        override val message: String,
) : BaseExceptionType {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.USER_NOT_FOUND_ERROR, "유저를 찾을 수 없습니다."),
    PROFILE_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.PROFILE_NOT_FOUND_ERROR, "프로필이 없습니다."),
    PROFILED_MAX_COUNT_EXCEED(HttpStatus.BAD_REQUEST, ErrorCode.PROFILED_MAX_COUNT_EXCEED, "프로필은 3개까지 만들 수 있습니다."),

    INTEREST_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.INTEREST_NOT_FOUND_ERROR, "해당 관심사 카테고리가 없습니다.")

    ALREADY_FOLLOWING(HttpStatus.OK, ErrorCode.ALREADY_FOLLOWING_ERROR, "이미 팔로잉하고 있습니다."),
    NOT_FOLLOWING_PROFILE(HttpStatus.OK, ErrorCode.NOT_FOLLOWING_PROFILE_ERROR, "팔로잉하고 있지 않습니다."),

    NOT_FOLLOWER_PROFILER(HttpStatus.OK, ErrorCode.NOT_FOLLOWER_PROFILE_ERROR, "팔로워가 아닙니다"),

    NOVEL_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.NOVEL_NOT_FOUND_ERROR, "해당 소설을 찾을 수 없습니다."),

    SURVEY_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.SURVEY_NOT_FOUND_ERROR, "북클럽을 열기 위해서는 가입 설문이 필요합니다."),

    ALREADY_JOINED(HttpStatus.OK, ErrorCode.ALREADY_JOINED_ERROR, "이미 가입하셨습니다.")
}