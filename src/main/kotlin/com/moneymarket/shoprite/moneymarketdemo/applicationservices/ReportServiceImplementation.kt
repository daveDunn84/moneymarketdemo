package com.moneymarket.shoprite.moneymarketdemo.applicationservices

import com.moneymarket.shoprite.moneymarketdemo.domainservices.dto.TransactionDto
import com.moneymarket.shoprite.moneymarketdemo.domainservices.mapper.TransactionMapper
import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.TransactionRepository
import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.UserRepository
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.ReportService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReportServiceImplementation : ReportService {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var transactionRepository: TransactionRepository

    @Autowired
    lateinit var userRepository: UserRepository

    override fun GenerateReport(accountNumber: String): List<TransactionDto> {

        val user = userRepository.GetUser(accountNumber)
        val transactions = transactionRepository.GetTransactionsForUser(user)
        val mappedTransactions = TransactionMapper().mapTransaction(transactions)

        return mappedTransactions
    }
}