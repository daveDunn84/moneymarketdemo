package com.moneymarket.shoprite.moneymarketdemo.applicationservices

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.AuthToken
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import com.moneymarket.shoprite.moneymarketdemo.domainservices.exceptions.AuthorizationFailedException
import com.moneymarket.shoprite.moneymarketdemo.domainservices.exceptions.UnauthorizedUserException
import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.UserRepository
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.AuthService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

// NOTE: This class is a mock auth service

@Service
class AuthServiceImplementation : AuthService {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var userRepository: UserRepository

    private val testToken = "qwertyuiopasdfghjklzxcvbnm123456"
    private val testUsername = "dave"
    private val testPassword = "dave"
    private val testAccountNumber = "ACC_001"

    override fun AuthenticateUser(username: String, password: String): AuthToken {
        logger.warn("Returning hard coded auth token for dave:dave for testing purposes.")

        if (username.equals(testUsername) && password.equals(testPassword)) {
            return AuthToken(testToken)
        } else {
            throw AuthorizationFailedException("User authentication failed. Username: ${username}.")
        }
    }

    override fun AuthorizeToken(authToken: AuthToken): User {

        if (authToken.token.equals("Bearer " + testToken)) {
            val user = userRepository.GetUser(testAccountNumber)
            return user
        } else {
            throw UnauthorizedUserException("The user is not authorized to perform this action.")
        }

    }
}