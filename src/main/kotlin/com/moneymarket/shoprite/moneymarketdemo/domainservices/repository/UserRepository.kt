package com.moneymarket.shoprite.moneymarketdemo.domainservices.repository

import org.apache.catalina.User

interface UserRepository {
    fun GetUser(username: String): User?
}