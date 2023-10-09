package org.cloudnovel.novel.core.domain.novel.likes

import org.cloudnovel.novel.core.domain.profile.profile.Profile
import org.cloudnovel.novel.core.domain.profile.profile.ProfileReader
import org.cloudnovel.novel.core.storage.likes.NovelLikesRepository
import org.springframework.stereotype.Component

@Component
class NovelLikesReader(private val novelLikesRepository: NovelLikesRepository,
                       private val profileReader: ProfileReader) {


    fun readByNovelId(novelId: Long): List<NovelLiker> {
        val likesEntities = novelLikesRepository.findByNovelId(novelId)

        return profileReader.readByIdIn(likesEntities.map { it.profileId }).map { toLiker(it) }
    }

    fun toLiker(profile: Profile): NovelLiker {
        return NovelLiker(profile.id, profile.nickname)
    }

}