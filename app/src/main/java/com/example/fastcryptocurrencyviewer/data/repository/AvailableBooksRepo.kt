package com.example.fastcryptocurrencyviewer.data.repository

import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse

interface AvailableBooksRepo {
    suspend fun loadAvailableBooks(): CryptoAvailableResponse
}
