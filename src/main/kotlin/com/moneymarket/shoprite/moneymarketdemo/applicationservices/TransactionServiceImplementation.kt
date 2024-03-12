package com.moneymarket.shoprite.moneymarketdemo.applicationservices

import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.TransactionService
import java.math.BigDecimal
import java.util.*

class TransactionServiceImplementation : TransactionService {
    override fun deposit(userId: UUID, currency: String, amount: BigDecimal) {
        TODO("Not yet implemented")
    }

    override fun transfer(fromUserId: UUID, toUserId: UUID, currency: String, amount: BigDecimal) {
        TODO("Not yet implemented")
    }
}