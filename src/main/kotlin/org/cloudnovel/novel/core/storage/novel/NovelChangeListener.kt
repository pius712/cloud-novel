package org.cloudnovel.novel.core.storage.novel

import jakarta.persistence.PostUpdate
import jakarta.persistence.PreUpdate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class NovelChangeListener(
//        private val novelHistoryRepository: NovelHistoryRepository

) {

//    companion object {
//        private val oldContent = ThreadLocal<String>();
//    }


    //    @Lazy
    @Autowired
    lateinit var novelHistoryRepository: NovelHistoryRepository

    @PreUpdate
    private fun preUpdate(novelEntity: NovelEntity) {
//        println(novelEntity.contents);
//        oldContent.set(novelEntity.contents)
    }

    @PostUpdate
    private fun postUpdate(novelEntity: NovelEntity) {
        novelHistoryRepository.save(
                NovelHistoryEntity(
                        novelEntity.lastModifierId,
                        novelEntity.contents,
                        novelEntity.contents
                )
        )
    }


}