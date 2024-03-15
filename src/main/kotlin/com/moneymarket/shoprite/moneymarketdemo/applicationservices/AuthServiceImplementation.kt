package com.moneymarket.shoprite.moneymarketdemo.applicationservices

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.AuthToken
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.UserRepository
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.AuthService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthServiceImplementation : AuthService {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun AuthenticateUser(username: String, password: String): AuthToken? {
        logger.warn("Returning hard coded auth token for testing purposes.")
        return AuthToken("ABCD1234")
    }

}