package org.cloudnovel.novel.core.domain.novel.novel

import org.cloudnovel.novel.core.storage.novel.NovelEntity
import org.cloudnovel.novel.core.storage.novel.NovelRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class NovelReader(
        private val novelRepository: NovelRepository,
) {

    fun readById(id: Long): Novel {
        val found = novelRepository.findByIdOrNull(id) ?: throw RuntimeException();

        return toNovel(found);
    }

    private fun toNovel(novelEntity: NovelEntity): Novel {
        return Novel(novelEntity.id!!, novelEntity.title, novelEntity.contents)
    }
}