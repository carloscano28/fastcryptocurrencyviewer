package com.example.fastcryptocurrencyviewer.data.repository

import com.example.fastcryptocurrencyviewer.data.model.CryptoM

interface AvailableBooksRepo {
    suspend fun loadAvailableBooks(): List<CryptoM>
}
