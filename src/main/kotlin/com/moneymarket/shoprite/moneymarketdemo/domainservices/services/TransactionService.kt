package com.moneymarket.shoprite.moneymarketdemo.domainservices.services

import java.math.BigDecimal
import java.util.*

interface TransactionService {
    fun deposit(userId: UUID, currency: String, amount: BigDecimal)
    fun transfer(fromUserId: UUID, toUserId: UUID, currency: String, amount: BigDecimal)
}