package org.cloudnovel.novel.core.domain.Interest

import org.springframework.stereotype.Service

@Service
class InterestWriteService(private val interestReader: InterestReader,
                           private val interestWriter: InterestWriter) {


    fun createInterest(createInterestRequest: CreateInterestRequest): Long {
        return interestWriter.write(createInterestRequest)
    }

}