package org.cloudnovel.novel.core.domain.Interest

import org.cloudnovel.novel.core.storage.profile.InterestEntity
import org.cloudnovel.novel.core.storage.profile.InterestRepository
import org.springframework.stereotype.Component

@Component
class InterestReader(
        private val interestRepository: InterestRepository,
) {
    fun readAll(): List<Interest> {
        return interestRepository.findAll().map(::toInterest);
    }

    fun readByCategory(category: String): List<Interest> {
        return interestRepository.findByCategory(category).map(::toInterest);
    }

    fun readByName(name: String): List<Interest> {
        return interestRepository.findByName(name).map(::toInterest)
    }

    private fun toInterest(entity: InterestEntity): Interest {
        return Interest(
                entity.id!!,
                entity.category,
                entity.name
        )
    }

}