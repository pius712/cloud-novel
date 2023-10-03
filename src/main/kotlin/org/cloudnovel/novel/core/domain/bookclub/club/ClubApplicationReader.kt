package org.cloudnovel.novel.core.domain.bookclub.club

import org.cloudnovel.novel.core.storage.club.*
import org.cloudnovel.novel.core.storage.profile.ProfileEntity
import org.cloudnovel.novel.core.storage.profile.ProfileRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ClubApplicationReader(
        private val memberRepository: ClubMemberRepository,
        private val profileRepository: ProfileRepository,
        private val answerRepository: ClubSurveyAnswerRepository,
        private val questionRepository: ClubSurveyQuestionRepository,
) {


    fun readByClub(clubId: Long): List<ClubApplicant> {

        val clubMemberEntities = memberRepository.findByClubId(clubId)
        val memberIds = clubMemberEntities.map { it.profileId }

        return profileRepository.findByIdIn(memberIds).map(::toApplicant)

    }

    fun readApplication(clubMemberId: Long): ClubApply {
        val memberEntity = memberRepository.findByIdOrNull(clubMemberId)
                ?: throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND)

        val profileEntity = profileRepository.findByIdOrNull(memberEntity.profileId)
                ?: throw CoreApiException(CoreExceptionType.PROFILE_NOT_FOUND)

        val answerEntities = answerRepository.findByClubMemberId(memberEntity.id!!)
        val questionEntities = questionRepository.findByIdIn(answerEntities.map { it.questionId })

        val joinSurveys = toSurveys(questionEntities, answerEntities)
        return toApplication(memberEntity, profileEntity, joinSurveys)
    }

    private fun toSurveys(questionEntities: List<ClubJoinSurveyQuestionEntity>, answerEntities: List<ClubSurveyAnswerEntity>): List<JoinSurvey> {
        val answerMap = answerEntities.groupBy { it.questionId }
        return questionEntities.map {
            val answer = answerMap[it.id]?.firstOrNull() ?: throw RuntimeException()
            JoinSurvey(it.sequence, it.question, answer.answer)
        }
    }

    private fun toApplicant(profileEntity: ProfileEntity): ClubApplicant {
        return ClubApplicant(
                profileEntity.id!!,
                profileEntity.nickname,
                profileEntity.bio,
        )
    }

    private fun toApplication(memberEntity: ClubMemberEntity,
                              profileEntity: ProfileEntity, joinSurveys: List<JoinSurvey>): ClubApply {
        return ClubApply(
                memberEntity.id!!,
                profileEntity.nickname,
                profileEntity.bio,
                joinSurveys,
        )
    }
}