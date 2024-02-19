package com.vcfj.jwtokens.model

import com.vcfj.jwtokens.enums.UserRoles
import java.util.UUID

data class User(
    val id: UUID,
    val email: String,
    val password: String,
    val role: UserRoles
)
