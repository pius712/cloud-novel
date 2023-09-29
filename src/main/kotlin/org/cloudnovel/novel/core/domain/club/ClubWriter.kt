package org.cloudnovel.novel.core.domain.club

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.common.enum.ClubRecruitStatus
import org.cloudnovel.novel.core.storage.club.ClubEntity
import org.cloudnovel.novel.core.storage.club.ClubRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
@Transactional
class ClubWriter(
        private val clubRepository: ClubRepository) {
    fun open(id: Long, status: ClubRecruitStatus): Long {
        return clubRepository.findByIdOrNull(id)?.let {
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
