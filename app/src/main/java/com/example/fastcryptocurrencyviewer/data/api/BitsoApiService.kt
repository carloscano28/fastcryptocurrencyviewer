package com.example.fastcryptocurrencyviewer.data.api

import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse
import com.example.fastcryptocurrencyviewer.utils.Resource
import retrofit2.http.GET

interface BitsoApiService {
    @GET(CryptoEndPoints.AVAILABLE_BOOKS)
    suspend fun getAvailableBooks(): CryptoAvailableResponse
}

object CryptoEndPoints {
    const val AVAILABLE_BOOKS =
        "available_books/"
    const val TICKER_BOOK =
        "ticker/"
    const val ORDER_SPECIFIED_BOOK =
        "order_book/"
}
