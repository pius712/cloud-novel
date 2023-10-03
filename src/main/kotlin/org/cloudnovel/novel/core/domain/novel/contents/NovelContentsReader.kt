package org.cloudnovel.novel.core.domain.novel.contents

import org.cloudnovel.novel.core.storage.novel.NovelEntity
import org.cloudnovel.novel.core.storage.novel.NovelRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class NovelContentsReader(
        private val novelRepository: NovelRepository,
) {

    fun readById(id: Long): NovelContents {
        val found = novelRepository.findByIdOrNull(id) ?: throw RuntimeException();

        return toNovel(found);
    }

    private fun toNovel(novelEntity: NovelEntity): NovelContents {
        return NovelContents(novelEntity.id!!, novelEntity.title, novelEntity.contents)
    }
}