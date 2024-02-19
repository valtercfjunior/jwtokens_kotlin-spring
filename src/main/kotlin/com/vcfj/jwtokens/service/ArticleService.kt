package com.vcfj.jwtokens.service

import com.vcfj.jwtokens.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {

    fun findAll() = articleRepository.findAll()
}