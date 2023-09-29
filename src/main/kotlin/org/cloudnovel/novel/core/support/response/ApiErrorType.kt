package org.cloudnovel.novel.core.support.response

import org.cloudnovel.novel.core.support.error.ErrorCode

data class ApiErrorType(
        val code: ErrorCode,
        val message: String
)
