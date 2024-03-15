package com.moneymarket.shoprite.moneymarketdemo.domainentities.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "user", schema="shoprite")
data class User (
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(name = "accountnumber", nullable = false)
    var accountNumber: String = "",

    @Column(name = "firstname", nullable = false)
    var firstname: String = "",

    @Column(name = "lastname", nullable = false)
    var lastname: String = "",

    @Column(name = "username", nullable = false)
    val username: String = "",

    @Column(name = "passwordhash", nullable = true)
    var passwordHash: String? = null,

    @Column(name = "passwordsalt", nullable = true)
    var passwordSalt: String? = null,

    @CreationTimestamp
    val createdAt: Date? = null
)