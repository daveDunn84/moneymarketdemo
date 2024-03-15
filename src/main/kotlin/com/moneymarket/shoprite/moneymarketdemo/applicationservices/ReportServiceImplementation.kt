package com.moneymarket.shoprite.moneymarketdemo.applicationservices

import com.moneymarket.shoprite.moneymarketdemo.domainentities.enums.TransactionType
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.ReportService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReportServiceImplementation : ReportService {
    private val logger = LoggerFactory.getLogger(javaClass)
    // todo: put this method header back, just string for testing
    override fun GenerateReport(accountNumber: String): List<Transaction> {
        // todo: pull data from db

        // mock this

        TODO("Not yet implemented")
    }

    override fun GenerateReportTest(accountNumber: String): String {
         return "Test Data!"
    }
}