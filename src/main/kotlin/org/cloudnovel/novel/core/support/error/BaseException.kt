package org.cloudnovel.novel.core.support.error

open class BaseException(
        val exceptionType: BaseExceptionType,
        val data: Any?
) : Error(exceptionType.message) {
}