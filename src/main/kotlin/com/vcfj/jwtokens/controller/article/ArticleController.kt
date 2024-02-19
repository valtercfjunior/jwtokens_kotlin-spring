package com.vcfj.jwtokens.controller.article

import com.vcfj.jwtokens.extension.toResponse
import com.vcfj.jwtokens.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/article")
class ArticleController(
    private var articleService: ArticleService
) {

    @GetMapping
    fun listAll(): List<ArticleResponse> = articleService.findAll()
        .map { it.toResponse() }


}