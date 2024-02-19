package com.vcfj.jwtokens.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig {

    @Bean
    fun customSwagger(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("JSToken")
                    .description("JWT + Spring Security + Kotlin")
            )
    }
}