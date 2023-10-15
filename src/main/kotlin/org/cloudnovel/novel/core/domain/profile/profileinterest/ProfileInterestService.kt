package org.cloudnovel.novel.core.domain.profile.profileinterest

import org.cloudnovel.novel.core.domain.Interest.Interest
import org.springframework.stereotype.Service

@Service
class ProfileInterestService(private val profileInterestReader: ProfileInterestReader,
                             private val profileInterestWriter: ProfileInterestWriter) {


    fun getInterestByProfile(profileId: Long): List<Interest> {
        return profileInterestReader.readByProfile(profileId);
    }

    fun updateInterest(profileId: Long, interestIds: List<Long>) {
        profileInterestWriter.updateInterest(profileId, interestIds);
    }
}