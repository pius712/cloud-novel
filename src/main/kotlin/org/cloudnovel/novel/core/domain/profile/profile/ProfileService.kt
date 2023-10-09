package org.cloudnovel.novel.core.domain.profile.profile

import org.springframework.stereotype.Service

@Service
class ProfileService(
        
        private val profileWriter: ProfileWriter,
        private val profileValidator: ProfileValidator
) {

    fun register(userId: Long, createRequest: ProfileCreateRequest): Long {
        profileValidator.canMakeProfile(userId);

        return profileWriter.write(userId, createRequest)
    }

    fun update(userId: Long, updateRequest: ProfileUpdateRequest): Profile {
        return profileWriter.update(userId, updateRequest)
    }
}