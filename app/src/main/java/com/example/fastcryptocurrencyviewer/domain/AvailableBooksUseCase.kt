package com.example.fastcryptocurrencyviewer.domain

import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailable
import com.example.fastcryptocurrencyviewer.data.model.asExternalModelView
import com.example.fastcryptocurrencyviewer.data.repository.AvailableBooksRepo
import com.example.fastcryptocurrencyviewer.utils.Utils
import javax.inject.Inject

class AvailableBooksUseCase@Inject constructor(private val repo : AvailableBooksRepo) {

    // Cuando la clase tiene solo una funcion se puede usar operator
    suspend operator fun invoke(): List<CryptoAvailable> {
        val resulAux = repo.loadAvailableBooks().asExternalModelView()
        return resulAux.coins!!.filter { coin->coin.coin.contains(Utils.CryptoConstants.MXN)}
    }
}