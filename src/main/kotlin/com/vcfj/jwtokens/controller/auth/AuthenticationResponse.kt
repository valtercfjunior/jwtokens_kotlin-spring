package com.vcfj.jwtokens.controller.auth

data class AuthenticationResponse(
    val accessToken: String,
    val refreshToken: String
)
