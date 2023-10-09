package org.cloudnovel.novel.core.domain.profile.profile

import org.springframework.stereotype.Service

@Service
class ProfileReadService(private val profileReader: ProfileReader) {
    
    fun getProfileById(id: Long): Profile {
        return profileReader.readById(id)
    }

    fun getProfileByUserId(userId: Long): Profile {
        return profileReader.readByUserId(userId)
    }

}