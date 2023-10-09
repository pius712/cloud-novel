package org.cloudnovel.novel.core.domain.profile.profile

import org.cloudnovel.novel.core.support.error.CoreApiException
import org.cloudnovel.novel.core.support.error.CoreExceptionType
import org.springframework.stereotype.Component

@Component
class ProfileValidator(val profileReader: ProfileReader) {


    fun canMakeProfile(userId: Long) {
        val count = profileReader.count(userId);
        if (count >= 3) {
            throw CoreApiException(CoreExceptionType.PROFILED_MAX_COUNT_EXCEED)
        }
        return
    }
}