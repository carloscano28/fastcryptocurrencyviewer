package com.example.fastcryptocurrencyviewer.data.network

import com.example.fastcryptocurrencyviewer.data.api.BitsoApiService
import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse
import javax.inject.Inject

class RetrofitClientImpl @Inject constructor(private val apiService: BitsoApiService) :
    NetworkDataSource {
    override suspend fun loadAvailableBooks(): CryptoAvailableResponse {
        return apiService.getAvailableBooks()
    }

}