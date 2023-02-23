package com.example.fastcryptocurrencyviewer.data.repository

import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse
import com.example.fastcryptocurrencyviewer.data.network.NetworkDataSource
import javax.inject.Inject

class AvailableBooksRepoImpl @Inject constructor(private val remoteDataSource: NetworkDataSource): AvailableBooksRepo {
    override suspend fun loadAvailableBooks() : CryptoAvailableResponse {
        return remoteDataSource.loadAvailableBooks()
    }
}