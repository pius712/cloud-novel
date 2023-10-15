package org.cloudnovel.novel.core.domain.Interest

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.storage.profile.InterestEntity
import org.cloudnovel.novel.core.storage.profile.InterestRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

/**
 * 카테고리를 별도로 나눠야하나..?
 * */
@Component
class InterestWriter(
        private val interestRepository: InterestRepository,
) {


    @Transactional
    fun updateName(id: Long, name: String) {
        val found = interestRepository.findByIdOrNull(id)
                ?: throw CoreApiException(CoreExceptionType.INTEREST_NOT_FOUND)

        found.apply { this.name = name }
    }

    @Transactional
    fun changeCategory(id: Long, category: String) {
        val found = interestRepository.findByIdOrNull(id)
                ?: throw CoreApiException(CoreExceptionType.INTEREST_NOT_FOUND)

        found.apply { this.category = category }
    }

    fun write(createInterestRequest: CreateInterestRequest): Long {
        return interestRepository.save(
                InterestEntity(
                        createInterestRequest.category,
                        createInterestRequest.name
                )
        ).id!!
    }
}