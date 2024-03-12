package com.moneymarket.shoprite.moneymarketdemo.domainentities.models

import java.util.UUID

data class User (
    private val id: UUID,
    private val firstname: String,
    private val lastname: String,
    private val username: String,
    private val passwordHash: String,
    private val passwordSalt: String
)