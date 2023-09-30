package org.cloudnovel.novel.core.domain.bookclub.member

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.common.enum.ClubParticipantStatus
import org.cloudnovel.novel.core.storage.club.ClubMemberEntity
import org.cloudnovel.novel.core.storage.club.ClubMemberRepository
import org.cloudnovel.novel.core.storage.club.SurveyAnswerEntity
import org.cloudnovel.novel.core.storage.club.SurveyAnswerRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.stereotype.Component


@Component
class ClubJoinWriter(private val answerRepository: SurveyAnswerRepository,
                     private val clubMemberRepository: ClubMemberRepository) {


    @Transactional
    fun prepareJoin(clubId: Long, profileId: Long, answers: List<JoinSurveyAnswer>) {
        if (clubMemberRepository.findByProfileId(profileId) != null) throw CoreApiException(CoreExceptionType.ALREADY_JOINED)

        answerRepository.saveAll(
                answers.map { SurveyAnswerEntity(it.surveyId, profileId, it.answer) }
        )

        clubMemberRepository.save(
                ClubMemberEntity(
                        clubId, profileId, ClubParticipantStatus.REQUEST
                )
        )
    }
}