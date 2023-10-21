package org.cloudnovel.novel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class NovelApplication

fun main(args: Array<String>) {
    runApplication<NovelApplication>(*args)
}
