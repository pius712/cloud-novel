package org.cloudnovel.novel.core.domain.profile.profile

import org.springframework.stereotype.Service

@Service
class UserProfileReadService(private val profileReader: UserProfileReader) {

    fun getProfileById(id: Long): UserProfile {
        return profileReader.readById(id)
    }

    fun getProfileByUserId(userId: Long): UserProfile {
        return profileReader.readByUserId(userId)
    }

}