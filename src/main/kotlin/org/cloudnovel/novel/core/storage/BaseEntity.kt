package org.cloudnovel.novel.core.storage

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null


    //    @CreatedDate
    // 위에는 안되고, 아래는 됨;
    @CreationTimestamp
    private val createDate: LocalDateTime? = null;

    @UpdateTimestamp
    private val lastModifiedDate: LocalDateTime? = null;
}