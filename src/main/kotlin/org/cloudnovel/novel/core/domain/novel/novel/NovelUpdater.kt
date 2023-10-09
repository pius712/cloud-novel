package org.cloudnovel.novel.core.domain.novel.novel

import org.cloudnovel.novel.core.storage.novel.NovelRepository
import org.springframework.stereotype.Component

@Component
class NovelUpdater(private val novelRepository: NovelRepository) {
}