package com.moneymarket.shoprite.moneymarketdemo.domainservices.services

import java.math.BigDecimal
import java.util.*

interface TransactionService {
    fun deposit(toAccountNumber: String, currency: String, amount: BigDecimal)
    fun transfer(fromAccountNumber: String, toAccountNumber: String, currency: String, amount: BigDecimal)
}