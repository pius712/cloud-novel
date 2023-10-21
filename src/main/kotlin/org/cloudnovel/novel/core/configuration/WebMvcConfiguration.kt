package org.cloudnovel.novel.core.configuration

import org.cloudnovel.novel.core.support.resolver.ServiceUserResolver
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfiguration(
        val serviceUserResolver: ServiceUserResolver
) : WebMvcConfigurer {


    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(serviceUserResolver)
    }
}