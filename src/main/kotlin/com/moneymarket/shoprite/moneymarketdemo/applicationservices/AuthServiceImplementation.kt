package com.moneymarket.shoprite.moneymarketdemo.applicationservices

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.AuthToken
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.AuthService

class AuthServiceImplementation : AuthService {
    override fun AuthenticateUser(username: String, password: String): AuthToken? {
        TODO("Not yet implemented")
    }

}