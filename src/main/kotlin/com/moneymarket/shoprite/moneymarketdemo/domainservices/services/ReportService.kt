package com.moneymarket.shoprite.moneymarketdemo.domainservices.services

import com.moneymarket.shoprite.moneymarketdemo.domainservices.dto.TransactionDto

interface ReportService {
    fun GenerateReport(accountNumber: String): List<TransactionDto>
}