package org.cloudnovel.novel.core.support.error

class CoreApiException(
        exceptionType: CoreExceptionType,
        data: Any? = null
) : BaseException(exceptionType, data) {
}