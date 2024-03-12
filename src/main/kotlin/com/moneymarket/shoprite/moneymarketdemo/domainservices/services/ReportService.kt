package com.moneymarket.shoprite.moneymarketdemo.domainservices.services

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import java.util.UUID

interface ReportService {
    fun GenerateReport(userId: UUID): List<Transaction>
}