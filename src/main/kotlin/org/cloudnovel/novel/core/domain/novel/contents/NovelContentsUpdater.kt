package org.cloudnovel.novel.core.domain.novel.contents

import org.cloudnovel.novel.core.storage.novel.NovelRepository
import org.springframework.stereotype.Component

@Component
class NovelContentsUpdater(private val novelRepository: NovelRepository) {
}