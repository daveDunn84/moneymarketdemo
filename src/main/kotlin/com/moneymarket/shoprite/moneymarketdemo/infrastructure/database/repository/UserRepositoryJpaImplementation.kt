package com.moneymarket.shoprite.moneymarketdemo.infrastructure.database.repository

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Repository
class UserRepositoryJpaImplementation : UserRepository {

    @Autowired
    lateinit var userJpaRepository : UserJpaRepository

    override fun SaveUser(user: com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User): com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User {
        return userJpaRepository.save(user)
    }

    override fun GetUser(accountId: String): User {
        val user = userJpaRepository.findByAccountNumber(accountId)
        return user
    }
}