package com.moneymarket.shoprite.moneymarketdemo.domainservices.services

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import com.moneymarket.shoprite.moneymarketdemo.domainservices.Dto.TransactionDto
import java.util.UUID

interface ReportService {
    fun GenerateReport(accountNumber: String): List<TransactionDto>
}