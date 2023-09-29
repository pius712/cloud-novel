package org.cloudnovel.novel.core.storage.profile

import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository : JpaRepository<ProfileEntity, Long> {

    fun findByUserId(userId: Long): ProfileEntity?
    fun findByIdIn(ids: List<Long>): List<ProfileEntity>
}