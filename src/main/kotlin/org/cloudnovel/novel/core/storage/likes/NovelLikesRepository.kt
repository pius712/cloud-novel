package org.cloudnovel.novel.core.storage.likes

import org.springframework.data.jpa.repository.JpaRepository

interface NovelLikesRepository : JpaRepository<NovelLikesEntity, Long> {
    fun findByNovelId(clubId: Long): List<NovelLikesEntity>
}