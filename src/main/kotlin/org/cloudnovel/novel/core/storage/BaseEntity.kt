package org.cloudnovel.novel.core.storage

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null


    @CreatedDate
    private val createDate: LocalDateTime? = null;

    @LastModifiedDate
    private val lastModifiedDate: LocalDateTime? = null;
}