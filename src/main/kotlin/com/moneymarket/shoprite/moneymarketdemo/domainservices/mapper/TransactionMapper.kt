package com.moneymarket.shoprite.moneymarketdemo.domainservices.mapper

import com.moneymarket.shoprite.moneymarketdemo.domainentities.enums.TransactionType
import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.Transaction
import com.moneymarket.shoprite.moneymarketdemo.domainservices.dto.TransactionDto

class TransactionMapper {
    fun mapTransaction(transactions: List<Transaction>) : List<TransactionDto> {

        val mappedTransactions: MutableList<TransactionDto> = mutableListOf()

        for (transaction in transactions) {
            var description = ""
            if (transaction.transactionType == TransactionType.DEPOSIT) {
                description = "Deposit into account number ${transaction.user.accountNumber}"
            } else if (transaction.transactionType == TransactionType.TRANSFER) {
                description = "Transfer from account number ${transaction.user.accountNumber} into account number ${transaction.user.accountNumber}"
            }

            val mappedTransaction = TransactionDto(
                transaction.createdAt.toString(),
                description,
                "",
                "${transaction.amount} ${transaction.currency}"
            )

            mappedTransactions.add(mappedTransaction)
        }

        return mappedTransactions
    }
}