package com.example.fastcryptocurrencyviewer.utils

import com.example.fastcryptocurrencyviewer.data.model.CryptoM

object Utils {
    class CryptoConstants {
        companion object {
            const val BITSO_URL = "https://api.bitso.com/v3/"
            const val MXN = "mxn"
            const val ERROR = "An unexpected error occured!!"
            const val ASK = "ASK"
            const val BID = "BID"
        }
    }

}

data class AvailableBooksUiState(
    val isLoading: Boolean = true,
    val characters: List<CryptoM> = emptyList(),
    val errorMessage: String? = null,
    val exception: Throwable? = null
)

// Value Object
sealed class Resource<out T> (val uiText: String = "", val data: T? = null){
    class Loading <out T> : Resource<T>()
    class Success <out T> ( data: T) : Resource<T>(data = data)
    class Error   <out T> (uiText: String) : Resource<T>( uiText = uiText)

}
