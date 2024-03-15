package com.moneymarket.shoprite.moneymarketdemo.domainservices.services

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.AuthToken
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User

interface AuthService {
    fun AuthenticateUser(username: String, password: String): AuthToken

    fun AuthorizeToken(token: AuthToken): User
}