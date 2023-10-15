package org.cloudnovel.novel.core.domain.Interest

import org.springframework.stereotype.Service

@Service
class InterestService(private val interestReader: InterestReader,
                      private val interestWriter: InterestWriter) {


    fun createInterest(createInterestRequest: CreateInterestRequest) {
        interestWriter.write(createInterestRequest)
    }


}