package com.example.fastcryptocurrencyviewer.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CryptoM(
    val book: String,
    val minimum_price: String,
    val maximum_price: String,
    val minimum_value: String,
    val maximum_value: String,
    val tick_size: String
) : Parcelable