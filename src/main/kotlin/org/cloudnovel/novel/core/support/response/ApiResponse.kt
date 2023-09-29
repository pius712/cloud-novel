package org.cloudnovel.novel.core.support.response

import org.cloudnovel.novel.core.support.error.BaseExceptionType

class ApiResponse<T>(
        val result: ApiResultType,
        val data: T?,
        val error: ApiErrorType?
) {

    companion object {
        fun <T> ok(): ApiResponse<T> {
            return ApiResponse(ApiResultType.SUCCESS, null, null);
        }

        fun <T> ok(data: T): ApiResponse<T> {
            return ApiResponse(ApiResultType.SUCCESS, data, null);
        }

        fun <T> error(exception: BaseExceptionType, data: T? = null): ApiResponse<T> {
            return ApiResponse(ApiResultType.ERROR, data, ApiErrorType(exception.code, exception.message));
        }
    }
}