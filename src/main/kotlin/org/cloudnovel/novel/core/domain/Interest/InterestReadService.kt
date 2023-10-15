package org.cloudnovel.novel.core.domain.Interest

import org.springframework.stereotype.Service

@Service
class InterestReadService(private val interestReader: InterestReader) {

    fun getInterests(): List<Interest> {
        return interestReader.readAll()
    }

    fun getInterestsByCategory(category: String): List<Interest> {
        return interestReader.readByCategory(category);
    }

}