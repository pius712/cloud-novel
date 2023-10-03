package org.cloudnovel.novel.core.domain.bookclub.club

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.common.enum.ClubRecruitStatus
import org.cloudnovel.novel.core.storage.club.ClubEntity
import org.cloudnovel.novel.core.storage.club.ClubRepository
import org.cloudnovel.novel.core.storage.club.ClubSurveyQuestionRepository
import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
@Transactional
class ClubWriter(
        private val clubRepository: ClubRepository,
        private val clubSurveyQuestionRepository: ClubSurveyQuestionRepository,
) {
    fun open(clubId: Long, status: ClubRecruitStatus): Long {
        if (clubSurveyQuestionRepository.findByClubId(clubId).isEmpty()) throw CoreApiException(CoreExceptionType.SURVEY_NOT_FOUND);

        return clubRepository.findByIdOrNull(clubId)?.let {
            it.recruitStatus = status
            it.id!!
        } ?: throw RuntimeException()
    }

    fun write(profileId: Long, clubCreateRequest: ClubCreateRequest): Long {
        return clubRepository.save(
                ClubEntity(
                        profileId,
                        clubCreateRequest.name,
                        clubCreateRequest.description,
                        ClubRecruitStatus.INIT,
                        clubCreateRequest.visibility,
                )).id!!
    }
}
