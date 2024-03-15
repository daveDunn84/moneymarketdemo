package com.moneymarket.shoprite.moneymarketdemo.domainentities.models

import com.moneymarket.shoprite.moneymarketdemo.domainentities.enums.TransactionType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.math.BigInteger
import java.util.UUID

@Entity
@Table(name = "transaction", schema = "shoprite")
public class Transaction(
    @Id
    val id: UUID = UUID.randomUUID(),

    @JoinColumn
    @ManyToOne
    val user: User = User(),

    @Column(name = "transactiontype", nullable = false)
    val transactionType: TransactionType = TransactionType.DEPOSIT, // todo: looking into a way to initialize this in a better way

    @Column(name = "currency", nullable = false)
    val currency: String = "",

    @Column(name = "amount", nullable = false)
    val amount: BigDecimal = BigDecimal(0)
)