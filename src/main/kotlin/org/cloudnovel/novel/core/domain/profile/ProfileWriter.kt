package org.cloudnovel.novel.core.domain.profile

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.storage.profile.ProfileEntity
import org.cloudnovel.novel.core.storage.profile.ProfileRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
@Transactional
class ProfileWriter(private val profileRepository: ProfileRepository) {
    fun write(userId: Long, createRequest: ProfileCreateRequest): Long {
        return profileRepository.save(ProfileEntity(createRequest.nickname, createRequest.bio,
                userId)).id!!
    }

    fun update(id: Long, updateRequest: ProfileUpdateRequest): Profile {
        return profileRepository.findByIdOrNull(id)?.let {
            it.bio = updateRequest.bio
            toProfile(it)
        } ?: throw RuntimeException()
    }

    fun toProfile(entity: ProfileEntity): Profile {
        return Profile(entity.id!!, entity.nickname, entity.bio, entity.userId)

    }

}