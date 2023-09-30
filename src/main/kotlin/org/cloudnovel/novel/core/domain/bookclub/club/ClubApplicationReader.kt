package org.cloudnovel.novel.core.domain.bookclub.club

import org.cloudnovel.novel.core.storage.club.ClubJoinSurveyQuestionRepository
import org.cloudnovel.novel.core.storage.club.ClubMemberRepository
import org.cloudnovel.novel.core.storage.club.SurveyAnswerEntity
import org.cloudnovel.novel.core.storage.club.SurveyAnswerRepository
import org.cloudnovel.novel.core.storage.profile.ProfileEntity
import org.cloudnovel.novel.core.storage.profile.ProfileRepository
import org.springframework.stereotype.Component

@Component
class ClubApplicationReader(private val memberRepository: ClubMemberRepository,
                            private val profileRepository: ProfileRepository,
                            private val clubJoinSurveyQuestionRepository: ClubJoinSurveyQuestionRepository,
                            private val answerRepository: SurveyAnswerRepository) {


    fun readByClub(clubId: Long) {
        val clubMemberEntity = memberRepository.findByClubId(clubId)
        val memberIds = clubMemberEntity.map { it.profileId }

        val memberProfiles = profileRepository.findByIdIn(memberIds)

        val joinQuestions = clubJoinSurveyQuestionRepository.findByClubId(clubId);

        val surveyAnswers = answerRepository.findByAndSurveyIdAndProfileIdIn(surveyId, memberProfiles.map { it.id!! })


        val answerMap = surveyAnswers.groupBy { it.profileId }
    }

    fun toApplicant(profileEntity: ProfileEntity, answerEntity: SurveyAnswerEntity): ClubApplication {
        return ClubApplication(
                profileEntity.id!!,
                profileEntity.nickname,
                profileEntity.bio,
                answerEntity
        )
    }
}