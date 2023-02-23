package com.example.fastcryptocurrencyviewer.repository

import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse

interface AvailableBooksRepo {

    suspend fun loadAvailableBooks(): CryptoAvailableResponse

}
