package org.cloudnovel.novel.core.controller

import org.cloudnovel.novel.core.support.error.BaseException
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CoreApiAdvice {

    @ExceptionHandler(BaseException::class)
    fun baseException(exception: BaseException): ResponseEntity<Any> {
        return ResponseEntity(ApiResponse.error(exception.exceptionType, exception.data), exception.exceptionType.status)
    }

}