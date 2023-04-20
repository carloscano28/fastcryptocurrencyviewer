package com.example.fastcryptocurrencyviewer.di

import com.example.fastcryptocurrencyviewer.data.api.BitsoApiService
import com.example.fastcryptocurrencyviewer.data.network.NetworkDataSource
import com.example.fastcryptocurrencyviewer.data.network.RetrofitClientImpl
import com.example.fastcryptocurrencyviewer.data.repository.AvailableBooksRepo
import com.example.fastcryptocurrencyviewer.data.repository.AvailableBooksRepoImpl
import com.example.fastcryptocurrencyviewer.utils.Utils
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent ::class)
abstract class CryptoModule {

    @Binds
    abstract fun providesAbailableBooksRepo(availableBooksRepo: AvailableBooksRepoImpl) : AvailableBooksRepo

    @Binds
    abstract fun providesNetworkDataSource(retrofitClientImpl: RetrofitClientImpl) : NetworkDataSource

    companion object {
        @Provides
        fun providesOkHttpClient() : OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().also { it.setLevel(HttpLoggingInterceptor.Level.BODY) })
            .build()

        @Provides
        fun providesRetrofitInstance (okHttpClient:OkHttpClient) : Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Utils.CryptoConstants.BITSO_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Para Rx java
            .addConverterFactory(GsonConverterFactory.create())
            //.addConverterFactory(MoshiConverterFactory.create())
            .build()

        @Provides
        fun providesCryptoService(retrofit: Retrofit) = retrofit.create<BitsoApiService>()
    }

}