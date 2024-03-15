package com.moneymarket.shoprite.moneymarketdemo.domainservices.services

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import java.util.UUID

interface ReportService {
    fun GenerateReport(accountNumber: String): List<Transaction>
    fun GenerateReportTest(accountNumber: String): String // Testing
}