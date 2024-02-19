package com.vcfj.jwtokens.repository

import com.vcfj.jwtokens.enums.UserRoles
import com.vcfj.jwtokens.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository(
    private val encoder: PasswordEncoder
) {

    private var users = mutableListOf(
        User(UUID.randomUUID(), "email-1@email.com", encoder.encode("pass1"), UserRoles.USER),
        User(UUID.randomUUID(), "email-2@email.com", encoder.encode("pass2"), UserRoles.ADMIN),
        User(UUID.randomUUID(), "email-3@email.com", encoder.encode("pass3"), UserRoles.USER),
    )

    fun save(user: User): Boolean {
        val updated = user.copy( password = encoder.encode(user.password))
        return users.add(updated)
    }

    fun findByEmail(email: String): User? = users
        .firstOrNull { it.email == email }

    fun findAll(): List<User> = users

    fun findById(id: UUID): User? = users.firstOrNull { it.id == id }

    fun delete(id: UUID): Boolean {
        val user = findById(id)

        return user?.let {
            users.remove(it)
        } ?: false
    }

}