package com.vcfj.jwtokens.repository

import com.vcfj.jwtokens.model.Article
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ArticleRepository {

    private val articles = listOf(
        Article(UUID.randomUUID(), "Article 1", "Content 1"),
        Article(UUID.randomUUID(), "Article 2", "Content 2")
    )

    fun findAll() = articles
}