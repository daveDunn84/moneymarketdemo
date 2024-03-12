package com.moneymarket.shoprite.moneymarketdemo.domainservices.services

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.AuthToken

interface AuthService {
    fun AuthenticateUser(username: String, password: String): AuthToken?
}