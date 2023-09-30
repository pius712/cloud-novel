package org.cloudnovel.novel.core.domain.bookclub.member

import org.cloudnovel.novel.core.domain.bookclub.ClubMember
import org.springframework.stereotype.Service


@Service
class ClubJoinService(
        val clubJoinWriter: ClubJoinWriter
) {
    fun requestJoin(clubMember: ClubMember, answers: List<JoinSurveyAnswer>) {
        return clubJoinWriter.prepareJoin(clubMember.clubId, clubMember.profileId, answers);
    }
}