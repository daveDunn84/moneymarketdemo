package com.moneymarket.shoprite.moneymarketdemo.presentation.controllers

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.AuthToken
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import com.moneymarket.shoprite.moneymarketdemo.domainservices.exceptions.AuthorizationFailedException
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.AuthService
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.UserCredentials
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(val authService: AuthService) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun GetUserToken(@RequestBody userCredentials: UserCredentials): ResponseEntity<String> {

        try {
            val authToken = authService.AuthenticateUser(userCredentials.username, userCredentials.password)
            return ResponseEntity(authToken.token, HttpStatus.OK)
        } catch (e: AuthorizationFailedException) {
            logger.info(e.message)
            return ResponseEntity(e.message, HttpStatus.UNAUTHORIZED)
        }

    }
}