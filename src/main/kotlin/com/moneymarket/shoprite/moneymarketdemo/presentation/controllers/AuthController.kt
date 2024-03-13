package com.moneymarket.shoprite.moneymarketdemo.presentation.controllers

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.AuthToken
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.AuthService
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.UserCredentials
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
    @PostMapping
    fun GetUserToken(@RequestBody userCredentials: UserCredentials): ResponseEntity<String> {
        val authToken = authService.AuthenticateUser(userCredentials.username, userCredentials.password)

        if (authToken == null) {
            return ResponseEntity("Invalid credentials.", HttpStatus.BAD_REQUEST)
        } else {
            return ResponseEntity(authToken.token.toString(), HttpStatus.OK)
        }
    }
}