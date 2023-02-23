package com.example.fastcryptocurrencyviewer.repository

import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse
import com.example.fastcryptocurrencyviewer.data.network.NetworkDataSource

class AvailableBooksRepoImpl(private val remoteDataSource: NetworkDataSource): AvailableBooksRepo{
    override suspend fun loadAvailableBooks() : CryptoAvailableResponse {
        return remoteDataSource.loadAvailableBooks()
    }
}