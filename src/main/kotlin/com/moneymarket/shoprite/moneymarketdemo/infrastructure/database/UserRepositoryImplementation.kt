package com.moneymarket.shoprite.moneymarketdemo.infrastructure.database

import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.UserRepository
import org.apache.catalina.User

class UserRepositoryImplementation : UserRepository {
    override fun GetUser(username: String): User? {
        TODO("Not yet implemented")
    }
}