package com.moneymarket.shoprite.moneymarketdemo.infrastructure.database.repository

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import com.moneymarket.shoprite.moneymarketdemo.presentation.controllers.TransactionController
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TransactionJpaRespository : JpaRepository<Transaction, UUID> {
    fun findByUserId(userId: UUID) : List<Transaction>
    fun findByUser(user: User) : List<Transaction>
}