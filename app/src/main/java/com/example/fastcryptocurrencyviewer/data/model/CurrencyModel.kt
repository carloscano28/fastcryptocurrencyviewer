package com.example.fastcryptocurrencyviewer.data.model

data class AvailableBooks(
    val coins: List<CryptoAvailable>? = emptyList()
)

data class CryptoM(
    val book: String,
    val minimum_amount: String,
    val maximum_amount: String,
    val minimum_price: String,
    val maximum_price: String,
    val minimum_value: String,
    val maximum_value: String,
    val tick_size: String
)