package org.cloudnovel.novel.core.domain.profile.profileinterest

import org.cloudnovel.novel.core.domain.Interest.Interest
import org.cloudnovel.novel.core.storage.profile.InterestEntity
import org.cloudnovel.novel.core.storage.profile.InterestRepository
import org.cloudnovel.novel.core.storage.profile.ProfileInterestRepository
import org.springframework.stereotype.Component

@Component
class ProfileInterestReader(
        private val profileInterestRepository: ProfileInterestRepository,
        private val interestRepository: InterestRepository
) {


    fun readByProfile(profileId: Long): List<Interest> {
        val found = profileInterestRepository.findByProfileId(profileId)
        val interestIds = found.map { it.interestId }

        val interestEntities = interestRepository.findAllById(interestIds)
        return interestEntities.map(::toInterest)
    }

    private fun toInterest(entity: InterestEntity): Interest {
        return Interest(
                entity.id!!,
                entity.category,
                entity.name
        )
    }
}