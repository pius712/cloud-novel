package org.cloudnovel.novel.core.support.error

import org.springframework.http.HttpStatus

interface BaseExceptionType {
    val status: HttpStatus;
    val code: ErrorCode;
    val message: String;
}