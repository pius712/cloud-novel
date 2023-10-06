package org.cloudnovel.novel.core.domain.profile.profile

import org.springframework.stereotype.Service

@Service
class ProfileService(
        private val profileReader: ProfileReader,
        private val profileWriter: ProfileWriter,
) {

    fun getProfileById(id: Long): Profile {
        return profileReader.readById(id)
    }

    fun getProfileByUserId(userId: Long): Profile {
        return profileReader.readByUserId(userId)
    }

    fun register(userId: Long, createRequest: ProfileCreateRequest): Long {
        return profileWriter.write(userId, createRequest)
    }


    fun update(userId: Long, updateRequest: ProfileUpdateRequest): Profile {
        return profileWriter.update(userId, updateRequest)
    }
}