package com.moneymarket.shoprite.moneymarketdemo.infrastructure.database.repository

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.User
import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionRepositoryJpaImplementation : TransactionRepository {

    @Autowired
    lateinit var transactionJpaRespository: TransactionJpaRespository

    override fun AddTransaction(transaction: Transaction) {
        transactionJpaRespository.save(transaction)
    }

    override fun GetTransactionsForUser(user: User) : List<Transaction> {
        return transactionJpaRespository.findByUser(user)
    }
}