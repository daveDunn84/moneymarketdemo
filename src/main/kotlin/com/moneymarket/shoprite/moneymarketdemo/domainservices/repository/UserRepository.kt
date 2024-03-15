package com.moneymarket.shoprite.moneymarketdemo.domainservices.repository

import org.apache.catalina.User

interface UserRepository {
    fun SaveUser(user: com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User): com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
    fun GetUser(accountId: String) : com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
}