package com.vcfj.jwtokens.controller.auth

data class AuthenticationRequest(
    val email: String,
    val password: String
)
