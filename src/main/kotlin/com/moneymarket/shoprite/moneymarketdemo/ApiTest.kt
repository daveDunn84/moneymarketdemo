package com.moneymarket.shoprite.moneymarketdemo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ping")
class ApiTest {

    @GetMapping
    fun GetPing(): ResponseEntity<Unit>  {
        return status(HttpStatus.OK).build()
    }

}