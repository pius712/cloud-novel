package org.cloudnovel.novel.core.storage.novel

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.cloudnovel.novel.core.storage.BaseEntity

@Entity
@Table(name = "novel")
class NovelEntity(
        @Column
        val title:String,
        @Column
        var contents: String
) :BaseEntity(){



}