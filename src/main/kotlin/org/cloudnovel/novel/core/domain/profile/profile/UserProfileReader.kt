package org.cloudnovel.novel.core.domain.profile.profile

import org.cloudnovel.novel.core.storage.profile.ProfileEntity
import org.cloudnovel.novel.core.storage.profile.ProfileRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserProfileReader(
        private val profileRepository: ProfileRepository
) {

    fun readById(id: Long): UserProfile {
        return profileRepository.findByIdOrNull(id)?.let { toProfile(it) }
                ?: throw RuntimeException()

    }

    fun readAllById(ids: List<Long>): List<UserProfile> {
        return profileRepository.findAllById(ids).map { toProfile(it) }
    }

    fun readByUserId(userId: Long): UserProfile {
        return profileRepository.findByUserId(userId)?.let { toProfile(it) }
                ?: throw RuntimeException()
    }

    fun toProfile(entity: ProfileEntity): UserProfile {
        return UserProfile(entity.id!!, entity.nickname, entity.bio, entity.userId)

    }

    fun count(userId: Long): Long {
        return profileRepository.countByUserId(userId)
    }

}