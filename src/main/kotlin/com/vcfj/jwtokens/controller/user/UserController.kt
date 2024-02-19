package com.vcfj.jwtokens.controller.user

import com.vcfj.jwtokens.extension.toUserModel
import com.vcfj.jwtokens.extension.toUserResponse
import com.vcfj.jwtokens.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun create(@RequestBody userRequest: UserRequest): UserResponse =
        userService.create(userRequest.toUserModel())?.toUserResponse()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create a user.")

    @GetMapping
    fun listAll(): List<UserResponse> =
        userService.findAll()
            .map { it.toUserResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): UserResponse =
        userService.findById(id)?.toUserResponse()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find the user.")

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Boolean> {
        val success = userService.delete(id)

        return if (success)
            ResponseEntity.noContent()
                .build()
        else
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot delete the user.")

    }
}