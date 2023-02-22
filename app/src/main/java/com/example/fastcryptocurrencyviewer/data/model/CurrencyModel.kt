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


/*data class CryptoBookDTO(
    val book: String = "",
    val minPrice: String = "",
    val maxPrice: String = "",
    val logo: Int = 0,
    val name: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: ""
    )*/
