package com.example.fastcryptocurrencyviewer.domain

import com.example.fastcryptocurrencyviewer.data.model.CryptoM
import com.example.fastcryptocurrencyviewer.data.repository.AvailableBooksRepo
import com.example.fastcryptocurrencyviewer.utils.Resource
import com.example.fastcryptocurrencyviewer.utils.Utils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AvailableBooksUseCase@Inject constructor(private val repo : AvailableBooksRepo) {

    // Cuando la clase tiene solo una funcion se puede usar operator
    suspend operator fun invoke(): Flow<Resource<List<CryptoM>>> = flow {

        emit(Resource.Loading())
        val result1 = repo.loadAvailableBooks()
            .filter { coin->coin.book.contains(Utils.CryptoConstants.MXN)}
        try {
            val resulAux = Resource.Success(result1)
            emit(resulAux)
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage ?: Utils.CryptoConstants.ERROR))
        }
    }
}