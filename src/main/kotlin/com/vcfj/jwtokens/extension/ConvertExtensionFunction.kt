package com.vcfj.jwtokens.extension

import com.vcfj.jwtokens.controller.article.ArticleResponse
import com.vcfj.jwtokens.controller.user.UserRequest
import com.vcfj.jwtokens.controller.user.UserResponse
import com.vcfj.jwtokens.enums.UserRoles
import com.vcfj.jwtokens.model.Article
import com.vcfj.jwtokens.model.User
import java.util.*

fun Article.toResponse(): ArticleResponse =
    ArticleResponse(
        id = this.id,
        title = this.title,
        content = this.content
    )

fun UserRequest.toUserModel(): User =
    User(
        id = UUID.randomUUID(),
        email = this.email,
        password = this.password,
        role = UserRoles.USER
    )

fun User.toUserResponse(): UserResponse =
    UserResponse(
        id = this.id,
        email = this.email
    )