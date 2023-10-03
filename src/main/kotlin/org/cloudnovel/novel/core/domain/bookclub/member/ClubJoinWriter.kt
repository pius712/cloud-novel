package org.cloudnovel.novel.core.domain.bookclub.member

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.common.enum.ClubParticipantStatus
import org.cloudnovel.novel.core.storage.club.ClubMemberEntity
import org.cloudnovel.novel.core.storage.club.ClubMemberRepository
import org.cloudnovel.novel.core.storage.club.ClubSurveyAnswerEntity
import org.cloudnovel.novel.core.storage.club.ClubSurveyAnswerRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.stereotype.Component


@Component
class ClubJoinWriter(private val answerRepository: ClubSurveyAnswerRepository,
                     private val clubMemberRepository: ClubMemberRepository) {


    @Transactional
    fun prepareJoin(clubId: Long, profileId: Long, answers: List<JoinSurveyAnswer>) {
        if (clubMemberRepository.findByProfileId(profileId) != null)
            throw CoreApiException(CoreExceptionType.ALREADY_JOINED)


        val clubMemberId = clubMemberRepository.save(
                ClubMemberEntity(
                        clubId, profileId, ClubParticipantStatus.REQUEST
                )
        ).id!!

        answerRepository.saveAll(
                answers.map { ClubSurveyAnswerEntity(it.questId, clubMemberId, it.answer) }
        )
    }
}