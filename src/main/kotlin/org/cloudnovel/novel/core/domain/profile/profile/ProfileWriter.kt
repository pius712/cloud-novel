package org.cloudnovel.novel.core.domain.profile.profile

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.storage.profile.ProfileEntity
import org.cloudnovel.novel.core.storage.profile.ProfileRepository
import org.cloudnovel.novel.core.storage.user.UserRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
@Transactional
class ProfileWriter(private val profileRepository: ProfileRepository,
                    private val userRepository: UserRepository) {
    fun write(userId: Long, createRequest: ProfileCreateRequest): Long {
        userRepository.findByIdOrNull(userId) ?: throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND);

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