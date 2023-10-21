package org.cloudnovel.novel.core.support.error

class ServiceApiException(exceptionType: BaseExceptionType,
                          data: Any? = null)
    : BaseException(exceptionType, data) {
}