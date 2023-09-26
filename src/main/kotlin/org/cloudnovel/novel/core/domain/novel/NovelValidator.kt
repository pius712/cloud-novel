package org.cloudnovel.novel.core.domain.novel

import org.springframework.stereotype.Component
import java.lang.RuntimeException


@Component
class NovelValidator {

    fun assertStartWithOriginalContent(prevBody:String, currentBody:String) {
        if(!currentBody.startsWith(prevBody)) {
            throw RuntimeException();
        }
    }
}