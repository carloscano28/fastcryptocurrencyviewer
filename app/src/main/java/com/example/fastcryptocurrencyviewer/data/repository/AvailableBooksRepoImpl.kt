package com.example.fastcryptocurrencyviewer.data.repository

import com.example.fastcryptocurrencyviewer.data.model.CryptoM
import com.example.fastcryptocurrencyviewer.data.model.asExternalListView
import com.example.fastcryptocurrencyviewer.data.network.NetworkDataSource
import javax.inject.Inject

class AvailableBooksRepoImpl @Inject constructor(private val remoteDataSource: NetworkDataSource): AvailableBooksRepo {
    override suspend fun loadAvailableBooks() : List<CryptoM> {
        var result : List<CryptoM>? = remoteDataSource.loadAvailableBooks().coins?.map {
            it.asExternalListView()
        }
        if(result.isNullOrEmpty()){
            result = emptyList()
        }
        return result
    }
}