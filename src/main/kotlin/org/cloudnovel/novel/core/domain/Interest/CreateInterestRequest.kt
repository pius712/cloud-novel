package org.cloudnovel.novel.core.domain.Interest

data class CreateInterestRequest(
        val category: String,
        val name: String,
) {
}