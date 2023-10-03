package org.cloudnovel.novel.core.domain.likes

import org.cloudnovel.novel.core.storage.likes.NovelLikesEntity
import org.cloudnovel.novel.core.storage.likes.NovelLikesRepository
import org.springframework.stereotype.Component

@Component
class NovelLikesWriter(private val novelLikesRepository: NovelLikesRepository) {


    fun write(novelId: Long, profileId: Long): Long {
        return novelLikesRepository.save(NovelLikesEntity(novelId, profileId)).id!!
    }

}