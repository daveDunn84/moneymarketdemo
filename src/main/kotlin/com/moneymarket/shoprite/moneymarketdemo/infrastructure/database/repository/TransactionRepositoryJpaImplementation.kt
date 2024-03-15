package com.moneymarket.shoprite.moneymarketdemo.infrastructure.database.repository

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import com.moneymarket.shoprite.moneymarketdemo.domainservices.repository.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionRepositoryJpaImplementation : TransactionRepository {

    @Autowired
    lateinit var transactionJpaRespository: TransactionJpaRespository
    override fun AddTransaction(transaction: Transaction) {
        transactionJpaRespository.save(transaction)
    }
}