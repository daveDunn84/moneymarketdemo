package com.moneymarket.shoprite.moneymarketdemo.presentation.models

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import com.moneymarket.shoprite.moneymarketdemo.domainservices.Dto.TransactionDto

// todo: this must return a List of DTO objects
class ReportResponse(val data: List<TransactionDto>?)