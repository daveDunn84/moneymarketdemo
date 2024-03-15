package com.moneymarket.shoprite.moneymarketdemo.infrastructure.database.repository

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserJpaRepository : JpaRepository<User, UUID> {
    fun findByAccountNumber(accountNumber: String) : User
}