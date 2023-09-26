package org.cloudnovel.novel.core.storage

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null



}