package com.example.fastcryptocurrencyviewer.data.model

import android.os.Parcel
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


data class CryptoBookDTO(
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
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(book)
        parcel.writeString(minPrice)
        parcel.writeString(maxPrice)
        parcel.writeInt(logo)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CryptoBookDTO> {
        override fun createFromParcel(parcel: Parcel): CryptoBookDTO {
            return CryptoBookDTO(parcel)
        }

        override fun newArray(size: Int): Array<CryptoBookDTO?> {
            return arrayOfNulls(size)
        }
    }
}