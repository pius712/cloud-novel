package org.cloudnovel.novel.core.domain.profile.profile

import org.springframework.stereotype.Service

@Service
class UserProfileService(

        private val userProfileWriter: UserProfileWriter,
        private val profileValidator: ProfileValidator
) {

    fun register(userId: Long, createRequest: UserProfileCreateRequest): Long {
        profileValidator.canMakeProfile(userId);

        return userProfileWriter.write(userId, createRequest)
    }

    fun update(userId: Long, updateRequest: UserProfileUpdateRequest): UserProfile {
        return userProfileWriter.update(userId, updateRequest)
    }
}