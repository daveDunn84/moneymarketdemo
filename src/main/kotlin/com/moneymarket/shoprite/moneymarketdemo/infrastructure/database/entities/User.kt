package com.moneymarket.shoprite.moneymarketdemo.infrastructure.database.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
class User(

    @Id
    @GeneratedValue
    val id: UUID,

    val firstname: String,

    val lastname: String,

    val username: String,

    val passwordHash: String,

    val passwordSalt: String
)