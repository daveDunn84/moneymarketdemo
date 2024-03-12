package com.moneymarket.shoprite.moneymarketdemo.domainentities.models

import com.moneymarket.shoprite.moneymarketdemo.domainentities.enums.TransactionType
import java.math.BigDecimal
import java.util.UUID

data class Transaction (
    private val id: UUID,
    private val userId: UUID,
    private val transactionType: TransactionType,
    private val currency: String,
    private val amount: BigDecimal
)