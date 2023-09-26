package org.cloudnovel.novel.core.domain.novel

import org.springframework.stereotype.Service


@Service
class NovelService(
        private val novelReader: NovelReader,
        private val novelWriter: NovelWriter,
        private val novelValidator: NovelValidator
) {

    fun register(createNovelRequest: CreateNovelRequest):Long {
        val id =  novelWriter.create(createNovelRequest)
        println(id);
        return id;
    }
    fun getNovel(id:Long):Novel {
        return novelReader.readById(id);

    }

    fun append(id:Long, appendNovelRequest: AppendNovelRequest):Long {

        val prevNovel = novelReader.readById(id);
        novelValidator.assertStartWithOriginalContent(prevNovel.body, appendNovelRequest.body)

        return  novelWriter.appendBody(id, appendNovelRequest)

    }
}