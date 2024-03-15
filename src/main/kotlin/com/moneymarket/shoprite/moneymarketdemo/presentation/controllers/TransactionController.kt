package com.moneymarket.shoprite.moneymarketdemo.presentation.controllers

import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.TransactionService
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.DepositRequest
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.TransactionResponse
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.TransferRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transaction")
class TransactionController(val transactionService: TransactionService) {
    private val logger = LoggerFactory.getLogger(javaClass)
    @PostMapping("/deposit")
    fun Deposit(@RequestBody depositRequest: DepositRequest): ResponseEntity<TransactionResponse> {
        try {
            transactionService.deposit(depositRequest.toAccountNumber, depositRequest.currency, depositRequest.amount)
            return ResponseEntity(TransactionResponse("Deposit performed successfully. Account Number: ${depositRequest.toAccountNumber}, Amount: ${depositRequest.amount} ${depositRequest.currency}."), HttpStatus.OK)
        } catch (e: Exception) {
            // todo: send a meaningful error from the deposit service
            return ResponseEntity(TransactionResponse("Deposit failed."), HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/transfer")
    fun Transfer(@RequestBody transferRequest: TransferRequest): ResponseEntity<TransactionResponse> {
        try {
            transactionService.transfer(transferRequest.fromAccountNumber, transferRequest.toAccountNumber, transferRequest.currency, transferRequest.amount)
            return ResponseEntity(TransactionResponse("Transfer performed successfully. From Account Number ${transferRequest.fromAccountNumber} to Account Number ${transferRequest.toAccountNumber}, Amount: ${transferRequest.amount} ${transferRequest.currency}."), HttpStatus.OK)
        } catch (e: Exception) {
            // todo: send a meaningful error from the transfer service
            return ResponseEntity(TransactionResponse("Transfer failed."), HttpStatus.BAD_REQUEST)
        }
    }
}