package org.cloudnovel.novel.core.controller

import org.cloudnovel.novel.core.support.error.GlobalExceptionType
import org.cloudnovel.novel.core.support.response.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException


@RestControllerAdvice
class GlobalAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException::class)
    fun noHandlerFound(): ApiResponse<Any> {
        return ApiResponse.error(GlobalExceptionType.NO_HANDLER_FOUND)
    }
}