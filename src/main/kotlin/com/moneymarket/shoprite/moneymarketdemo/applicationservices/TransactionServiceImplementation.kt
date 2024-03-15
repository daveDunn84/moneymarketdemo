package com.moneymarket.shoprite.moneymarketdemo.applicationservices

import com.moneymarket.shoprite.moneymarketdemo.domainentities.enums.TransactionType
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.TransactionRepository
import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.UserRepository
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.TransactionService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class TransactionServiceImplementation : TransactionService {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var transactionRepository: TransactionRepository

    @Autowired
    lateinit var userRepository: UserRepository

    override fun deposit(toAccountNumber: String, currency: String, amount: BigDecimal) {

        val user = userRepository.GetUser(toAccountNumber)
        val transaction = Transaction(UUID.randomUUID(), user, TransactionType.DEPOSIT, currency, amount)

        transactionRepository.AddTransaction(transaction)
    }

    override fun transfer(fromAccountNumber: String, toAccountNumber: String, currency: String, amount: BigDecimal) {
        val fromUser = userRepository.GetUser(fromAccountNumber)
        val toUser = userRepository.GetUser(toAccountNumber)

        val outTransaction = Transaction(UUID.randomUUID(), fromUser, TransactionType.TRANSFER, currency, amount.times(BigDecimal(-1)))
        val inTransaction = Transaction(UUID.randomUUID(), toUser, TransactionType.TRANSFER, currency, amount)

        transactionRepository.AddTransaction(outTransaction)
        transactionRepository.AddTransaction(inTransaction)
    }
}