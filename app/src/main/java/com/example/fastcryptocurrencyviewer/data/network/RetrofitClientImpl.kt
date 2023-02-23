package com.example.fastcryptocurrencyviewer.data.network

import com.example.fastcryptocurrencyviewer.data.api.BitsoApiService
import com.example.fastcryptocurrencyviewer.data.api.RetrofitSingleton
import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse
import retrofit2.create

class RetrofitClientImpl (private val apiService: BitsoApiService = RetrofitSingleton.retrofit.create()) : NetworkDataSource {

    override suspend fun loadAvailableBooks(): CryptoAvailableResponse {
        return apiService.getAvailableBooks()
    }

}