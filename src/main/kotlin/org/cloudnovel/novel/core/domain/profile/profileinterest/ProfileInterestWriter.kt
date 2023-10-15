package org.cloudnovel.novel.core.domain.profile.profileinterest

import org.cloudnovel.novel.core.storage.profile.ProfileInterestEntity
import org.cloudnovel.novel.core.storage.profile.ProfileInterestRepository
import org.springframework.stereotype.Component

@Component
class ProfileInterestWriter(
        private val profileInterestRepository: ProfileInterestRepository
) {


    fun updateInterest(profileId: Long, interestIds: List<Long>) {
        profileInterestRepository.deleteAllByProfileId(profileId);
        profileInterestRepository.saveAll(
                interestIds.map { ProfileInterestEntity(profileId, it) }
        )
    }


}