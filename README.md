# moneymarketdemo
Shoprite Money Market Assessment Application

# API Documentation

## Auth Token [/auth]
### [POST]

Request an auth token for the specified user

+ Response 200 (application/json)

Headers:
```
Content-Type: application/json
Authorization: token received from auth endpoint
```

Body:
```
{
    "username":"username",
    "password":"password"
}
```

## Transfer [/transaction/transfer]
### [POST]

Perform a transfer from one account to another for a specific amount in a specific currencyPerform a transfer from one account to another for a specific amount in a specific currency

+ Response 200 (application/json)

Headers:
```
Content-Type: application/json
Authorization: token received from auth endpoint
```

Body:
```
{
    "toAccountNumber":"ACC_002",
    "amount":122.17,
    "currency":"ZAR"
}
```

## Deposit [/transaction/deposit]
### [POST]

Perform a deposit into an account for a specific amount in a specific currencyPerform a transfer from one account to another for a specific amount in a specific currency

+ Response 200 (application/json)

Headers:
```
Content-Type: application/json
Authorization: token received from auth endpoint
```

Body:
```
{
    "amount":122.17,
    "currency":"ZAR"
}
```

## Report [/report/generate]
### [GET]

Retrieve transaction data for a specified user

+ Response 200 (application/json)

Headers:
```
Content-Type: application/json
Authorization: token received from auth endpoint
```