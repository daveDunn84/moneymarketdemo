package com.moneymarket.shoprite.moneymarketdemo.presentation.controllers

import com.moneymarket.shoprite.moneymarketdemo.domainentities.models.AuthToken
import com.moneymarket.shoprite.moneymarketdemo.domainservices.exceptions.AuthorizationFailedException
import com.moneymarket.shoprite.moneymarketdemo.domainservices.exceptions.UnauthorizedUserException
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.AuthService
import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.TransactionService
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.DepositRequest
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.TransactionResponse
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.TransferRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transaction")
class TransactionController(val transactionService: TransactionService, val authService: AuthService) {
    private val logger = LoggerFactory.getLogger(javaClass)
    @PostMapping("/deposit")
    fun Deposit(@RequestBody depositRequest: DepositRequest, @RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String): ResponseEntity<TransactionResponse> {
        try {
            val authToken = AuthToken(authHeader)
            val authorizedUser = authService.AuthorizeToken(authToken)
            transactionService.deposit(authorizedUser.accountNumber, depositRequest.currency, depositRequest.amount)

            return ResponseEntity(TransactionResponse("Deposit performed successfully. Account Number: ${authorizedUser.accountNumber}, Amount: ${depositRequest.amount} ${depositRequest.currency}."), HttpStatus.OK)
        } catch (unauthorizedUserException: UnauthorizedUserException) {
            logger.info(unauthorizedUserException.message)
            return ResponseEntity(TransactionResponse("Deposit failed. ${unauthorizedUserException.message}"), HttpStatus.UNAUTHORIZED)
        } catch (e: Exception) {
            logger.error(e.message)
            return ResponseEntity(TransactionResponse("Deposit failed. The error has been logged."), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("/transfer")
    fun Transfer(@RequestBody transferRequest: TransferRequest, @RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String): ResponseEntity<TransactionResponse> {
        try {
            val authToken = AuthToken(authHeader)
            val authorizedUser = authService.AuthorizeToken(authToken)
            transactionService.transfer(authorizedUser.accountNumber, transferRequest.toAccountNumber, transferRequest.currency, transferRequest.amount)

            return ResponseEntity(TransactionResponse("Transfer performed successfully. From Account Number ${authorizedUser.accountNumber} to Account Number ${transferRequest.toAccountNumber}, Amount: ${transferRequest.amount} ${transferRequest.currency}."), HttpStatus.OK)

        } catch (unauthorizedUserException: UnauthorizedUserException) {
            logger.info(unauthorizedUserException.message)
            return ResponseEntity(TransactionResponse("Transfer failed. ${unauthorizedUserException.message}"), HttpStatus.UNAUTHORIZED)
        } catch (e: Exception) {
            logger.error(e.message)
            return ResponseEntity(TransactionResponse("Transfer failed. The error has been logged."), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}