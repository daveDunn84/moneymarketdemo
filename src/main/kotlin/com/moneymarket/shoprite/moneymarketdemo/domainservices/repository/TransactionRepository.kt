package com.moneymarket.shoprite.moneymarketdemo.domainservices.repository

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction

interface TransactionRepository {
    fun AddTransaction(transaction: Transaction)
}