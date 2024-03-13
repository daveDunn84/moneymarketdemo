package com.moneymarket.shoprite.moneymarketdemo.applicationservices

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.AuthToken
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.AuthService
import org.springframework.stereotype.Service

@Service
class AuthServiceImplementation : AuthService {
    override fun AuthenticateUser(username: String, password: String): AuthToken? {
        // todo: token generation logic
        return AuthToken("ABCD1234")
    }

}