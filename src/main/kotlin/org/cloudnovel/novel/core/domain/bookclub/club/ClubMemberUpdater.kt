package org.cloudnovel.novel.core.domain.bookclub.club

import org.cloudnovel.novel.core.common.enum.ClubParticipantStatus
import org.cloudnovel.novel.core.domain.bookclub.ClubMember
import org.cloudnovel.novel.core.storage.club.ClubMemberRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.stereotype.Component


@Component
class ClubMemberUpdater(val participantRepository: ClubMemberRepository) {


    fun updateParticipantStatus(clubMember: ClubMember, participantStatus: ClubParticipantStatus): Long {
        return participantRepository.findByClubIdAndProfileId(clubMember.clubId, clubMember.profileId)?.let {
            it.participantStatus = participantStatus
            it.profileId
        } ?: throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND)
    }

}