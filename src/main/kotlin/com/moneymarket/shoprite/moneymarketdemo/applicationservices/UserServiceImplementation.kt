package com.moneymarket.shoprite.moneymarketdemo.applicationservices

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.UserRepository
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImplementation : UserService {
    private val logger = LoggerFactory.getLogger(javaClass)
    @Autowired
    lateinit var userRepository: UserRepository

    override fun SaveUser(user: User): User {
        return userRepository.SaveUser(user)
    }
}