package com.example.fastcryptocurrencyviewer.data.network

import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse

interface NetworkDataSource {
    suspend fun loadAvailableBooks() : CryptoAvailableResponse
}