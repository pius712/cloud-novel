package org.cloudnovel.novel.core.storage.profile

import org.springframework.data.jpa.repository.JpaRepository

interface InterestRepository : JpaRepository<InterestEntity, Long> {
    fun findByCategory(category: String): List<InterestEntity>
    fun findByName(name: String): List<InterestEntity>
}