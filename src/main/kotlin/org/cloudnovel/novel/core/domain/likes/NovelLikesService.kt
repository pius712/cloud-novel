package org.cloudnovel.novel.core.domain.likes

import org.springframework.stereotype.Service

@Service
class NovelLikesService(private val novelLikesWriter: NovelLikesWriter,
                        private val novelLikesReader: NovelLikesReader) {


    fun likesNovel(novelId: Long, profileId: Long): Long {
        return novelLikesWriter.write(novelId, profileId)
    }

    fun getLiker(novelId: Long): List<Liker> {
        return novelLikesReader.readByNovelId(novelId)
    }
}