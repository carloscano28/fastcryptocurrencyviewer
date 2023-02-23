package com.example.fastcryptocurrencyviewer.data.api

import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse
import com.example.fastcryptocurrencyviewer.utils.Utils
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BitsoApiService {
    @GET(CryptoEndPoints.AVAILABLE_BOOKS)
    fun getExchangeBooksRx(): Single<Response<CryptoAvailableResponse>>

    @GET(CryptoEndPoints.AVAILABLE_BOOKS)
    suspend fun getAvailableBooks(): CryptoAvailableResponse
}

object CryptoEndPoints {
    const val AVAILABLE_BOOKS =
        "available_books/"
    const val TICKER_BOOK =
        "ticker/"
    const val ORDER_SPECIFIED_BOOK =
        "order_book/"
}
