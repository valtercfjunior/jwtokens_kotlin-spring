package com.vcfj.jwtokens.service

import com.vcfj.jwtokens.model.User
import com.vcfj.jwtokens.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun create(_user: User): User? {
        val user = userRepository.findByEmail(_user.email)

        return if (user == null) {
            userRepository.save(_user)
            _user
        } else null
    }

    fun findById(id: UUID): User? = userRepository.findById(id)

    fun findAll(): List<User> = userRepository.findAll()

    fun delete(id: UUID): Boolean = userRepository.delete(id)
}