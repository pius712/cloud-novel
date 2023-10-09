package org.cloudnovel.novel.core.domain.novel.novel

import org.springframework.stereotype.Component


@Component
class NovelValidator {

    fun assertStartWithOriginalContent(prevBody: String, currentBody: String) {
        if (!currentBody.startsWith(prevBody)) {
            throw RuntimeException();
        }
    }
}