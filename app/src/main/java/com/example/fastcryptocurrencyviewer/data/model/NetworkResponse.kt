package com.example.fastcryptocurrencyviewer.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CryptoAvailableResponse(
    @SerializedName("success")
    @Expose
    val success: Boolean = false,
    @SerializedName("payload")
    @Expose
    val coins: List<CryptoAvailable>? = emptyList()
):Parcelable

fun CryptoAvailable.asExternalListView() = CryptoM(
    book = coin, minimum_amount = minAmount, maximum_amount = maxAmount
)

@Parcelize
data class CryptoAvailable(
    @SerializedName("book")
    @Expose
    val coin: String = "",
    @SerializedName("minimum_amount")
    @Expose
    val minAmount: String = "",
    @SerializedName("maximum_amount")
    @Expose
    val maxAmount: String = "",
    @SerializedName("minimum_price")
    @Expose
    val minPrice: String = "",
    @SerializedName("maximum_price")
    @Expose
    val maxPrice: String = "",
    @SerializedName("minimum_value")
    @Expose
    val minValue: String = "",
    @SerializedName("maximum_value")
    @Expose
    val maxValue: String = ""
):Parcelable