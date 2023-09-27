package org.cloudnovel.novel.core.domain.profile

import org.cloudnovel.novel.core.storage.profile.ProfileEntity
import org.cloudnovel.novel.core.storage.profile.ProfileRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ProfileReader(
        private val profileRepository: ProfileRepository
) {

    fun readById(id: Long): Profile {
        return profileRepository.findByIdOrNull(id)?.let { toProfile(it) }
                ?: throw RuntimeException()

    }

    fun readByUserId(userId: Long): Profile {
        return profileRepository.findByUserId(userId)?.let { toProfile(it) }
                ?: throw RuntimeException()
    }

    fun toProfile(entity: ProfileEntity): Profile {
        return Profile(entity.id!!, entity.nickname, entity.bio, entity.userId)

    }


}