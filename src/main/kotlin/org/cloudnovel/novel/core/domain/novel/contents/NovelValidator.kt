package org.cloudnovel.novel.core.domain.novel.contents

import org.springframework.stereotype.Component


@Component
class NovelValidator {

    fun assertStartWithOriginalContent(prevBody: String, currentBody: String) {
        if (!currentBody.startsWith(prevBody)) {
            throw RuntimeException();
        }
    }
}