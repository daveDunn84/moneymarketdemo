package com.moneymarket.shoprite.moneymarketdemo.domainservices.repository

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import java.util.UUID

interface TransactionRepository {
    fun AddTransaction(transaction: Transaction)

    fun GetTransactionsForUser(user: User) : List<Transaction>
}