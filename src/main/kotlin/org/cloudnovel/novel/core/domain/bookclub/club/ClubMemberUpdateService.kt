package org.cloudnovel.novel.core.domain.bookclub.club

import org.cloudnovel.novel.core.common.enum.ClubParticipantStatus
import org.cloudnovel.novel.core.domain.bookclub.ClubMember
import org.springframework.stereotype.Service

@Service
class ClubMemberUpdateService(private val participantUpdater: ClubMemberUpdater) {

    fun approveJoin(clubMember: ClubMember): Long {
        return participantUpdater.updateParticipantStatus(clubMember, ClubParticipantStatus.APPROVE)
    }

    fun banClubMember(clubMember: ClubMember): Long {
        return participantUpdater.updateParticipantStatus(clubMember, ClubParticipantStatus.BAN)
    }

}