package com.moneymarket.shoprite.moneymarketdemo.presentation.controllers

import com.moneymarket.shoprite.moneymarketdemo.domainservices.services.ReportService
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.DepositRequest
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.ReportResponse
import com.moneymarket.shoprite.moneymarketdemo.presentation.models.TransactionResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/report")
class ReportController(val reportService: ReportService) {
    private val logger = LoggerFactory.getLogger(javaClass)
    @GetMapping("/generate")
    fun GenerateReport(@RequestParam(required = true) accountNumber: String): ResponseEntity<ReportResponse> {
        try {
            val data = reportService.GenerateReport(accountNumber)
            return ResponseEntity(ReportResponse(data), HttpStatus.OK)
        } catch (e: Exception) {
            // todo: send a meaningful error from the report service
            return ResponseEntity(ReportResponse(null), HttpStatus.BAD_REQUEST)
        }
    }
}