package com.moneymarket.shoprite.moneymarketdemo.presentation.models

import org.apache.catalina.User
import java.math.BigDecimal

open class TransactionRequest {
    val amount: BigDecimal = BigDecimal(0)
    val currency: String = ""
}