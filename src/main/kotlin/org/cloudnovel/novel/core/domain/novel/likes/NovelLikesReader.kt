package org.cloudnovel.novel.core.domain.novel.likes

import org.cloudnovel.novel.core.domain.profile.profile.UserProfile
import org.cloudnovel.novel.core.domain.profile.profile.UserProfileReader
import org.cloudnovel.novel.core.storage.likes.NovelLikesRepository
import org.springframework.stereotype.Component

@Component
class NovelLikesReader(private val novelLikesRepository: NovelLikesRepository,
                       private val userProfileReader: UserProfileReader) {


    fun readByNovelId(novelId: Long): List<NovelLiker> {
        val likesEntities = novelLikesRepository.findByNovelId(novelId)

        return userProfileReader.readAllById(likesEntities.map { it.profileId }).map { toLiker(it) }
    }

    fun toLiker(userProfile: UserProfile): NovelLiker {
        return NovelLiker(userProfile.id, userProfile.nickname)
    }

}