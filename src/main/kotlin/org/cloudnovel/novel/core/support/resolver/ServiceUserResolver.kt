package org.cloudnovel.novel.core.support.resolver

import org.cloudnovel.novel.core.domain.serviceUser.ServiceUser
import org.cloudnovel.novel.core.support.error.ServiceApiException
import org.cloudnovel.novel.core.support.error.ServiceExceptionType
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class ServiceUserResolver : HandlerMethodArgumentResolver {
    companion object {
        val USER_ID = "x-user-id";
        val PROFILE_ID = "x-profile-id"
    }

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.parameterType === ServiceUser::class.java
    }

    override fun resolveArgument(parameter: MethodParameter, mavContainer: ModelAndViewContainer?, webRequest: NativeWebRequest, binderFactory: WebDataBinderFactory?): ServiceUser {

        val userId = webRequest.getHeader(USER_ID)?.toLongOrNull()
                ?: throw ServiceApiException(ServiceExceptionType.NOT_FOUND_USER_ID)
        val profileId = webRequest.getHeader(PROFILE_ID)?.toLongOrNull()
                ?: throw ServiceApiException(ServiceExceptionType.NOT_FOUND_USER_ID)
        return ServiceUser(userId, profileId)
    }
}