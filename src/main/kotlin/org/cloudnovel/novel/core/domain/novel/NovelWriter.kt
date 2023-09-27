package org.cloudnovel.novel.core.domain.novel

import jakarta.transaction.Transactional
import org.cloudnovel.novel.core.storage.novel.NovelEntity
import org.cloudnovel.novel.core.storage.novel.NovelRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
@Transactional
class NovelWriter(private val novelRepository: NovelRepository) {

    fun create(novelCreateRequest: NovelCreateRequest):Long {
        return novelRepository.save(
                NovelEntity(
                        novelCreateRequest.title,
                        novelCreateRequest.body
                )
        ).id!!
    }

    fun appendBody(id:Long, appendNovelRequest: AppendNovelRequest):Long {

        val found =  novelRepository.findByIdOrNull(id)?.let {
            it.contents = appendNovelRequest.body
            it;
        } ?: throw RuntimeException()
        return found.id!!

    }

}