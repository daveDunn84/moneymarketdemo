package com.moneymarket.shoprite.moneymarketdemo.presentation.controllers

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.UserService
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.UserCredentials
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {
    private val logger = LoggerFactory.getLogger(javaClass)
    @PostMapping
    fun SaveUser(@RequestBody user: User): ResponseEntity<User> {

        try {
            val newUser = userService.SaveUser(user)
            return ResponseEntity(newUser, HttpStatus.CREATED)
        } catch (e: Exception) {
            return ResponseEntity(null, HttpStatus.BAD_REQUEST)
        }
    }
}