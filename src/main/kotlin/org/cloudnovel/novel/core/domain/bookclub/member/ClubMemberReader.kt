package org.cloudnovel.novel.core.domain.bookclub.member

import org.cloudnovel.novel.core.storage.club.ClubMemberRepository
import org.cloudnovel.novel.core.storage.profile.ProfileEntity
import org.cloudnovel.novel.core.storage.profile.ProfileRepository
import org.springframework.stereotype.Component

@Component
class ClubMemberReader(private val clubMemberRepository: ClubMemberRepository,
                       private val profileRepository: ProfileRepository) {


    fun readByClubId(clubId: Long): List<ClubMemberProfile> {
        val clubMembers = clubMemberRepository.findByClubId(clubId);
        return profileRepository.findByIdIn(clubMembers.map { it.profileId }).map(::toMemberProfile)
    }

    fun toMemberProfile(profileEntity: ProfileEntity): ClubMemberProfile {
        return ClubMemberProfile(profileEntity.id!!, profileEntity.nickname, profileEntity.bio);
    }
}