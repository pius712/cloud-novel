package org.cloudnovel.novel.core.storage.novel

import org.springframework.data.jpa.repository.JpaRepository

interface NovelHistoryRepository : JpaRepository<NovelHistoryEntity, Long> {
}