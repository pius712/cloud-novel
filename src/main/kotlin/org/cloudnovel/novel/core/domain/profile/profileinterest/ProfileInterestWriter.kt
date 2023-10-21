package org.cloudnovel.novel.core.domain.profile.profileinterest

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.domain.profile.profile.UserProfileReader
import org.cloudnovel.novel.core.storage.profile.ProfileInterestEntity
import org.cloudnovel.novel.core.storage.profile.ProfileInterestRepository
import org.springframework.stereotype.Component

@Component
class ProfileInterestWriter(
        private val userProfileReader: UserProfileReader,
        private val profileInterestRepository: ProfileInterestRepository
) {


    @Transactional
    fun updateInterest(profileId: Long, interestIds: List<Long>) {
        userProfileReader.readById(profileId);

        profileInterestRepository.deleteAllByProfileId(profileId);
        profileInterestRepository.saveAll(
                interestIds.map { ProfileInterestEntity(profileId, it) }
        )
    }
}