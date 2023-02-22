package com.example.fastcryptocurrencyviewer.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass



@JsonClass(generateAdapter = true)
data class CryptoAvailableResponseMoshi(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)

data class CryptoAvailableResponse(
    @SerializedName("success")
    @Expose
    val success: Boolean = false,

    @SerializedName("payload")
    @Expose
    val coins: List<CryptoAvailable>? = null
)

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
) {
    //fun returnTxt () : String =  " My txt "
    /*fun toBook(): CryptoBookDTO =
        when (coin) {
            Utils.CoinType.BITCOIN.value -> CryptoBookDTO(
                book = coin,
                name = Utils.CoinType.BITCOIN.coin,
                minPrice = minPrice,
                maxPrice = maxPrice,
                logo = R.drawable.ic_bitcoin
            )
            Utils.CoinType.ETHEREUM.value -> CryptoBookDTO(
                book = coin,
                name = Utils.CoinType.ETHEREUM.coin,
                minPrice = minPrice,
                maxPrice = maxPrice,
                logo = R.drawable.ic_ethereum
            )
            Utils.CoinType.XRP.value -> CryptoBookDTO(
                book = coin,
                name = Utils.CoinType.XRP.coin,
                minPrice = minPrice,
                maxPrice = maxPrice,
                logo = R.drawable.ic_xrp
            )
            Utils.CoinType.LITECOIN.value -> CryptoBookDTO(
                book = coin,
                name = Utils.CoinType.LITECOIN.coin,
                minPrice = minPrice,
                maxPrice = maxPrice,
                logo = R.drawable.ic_litecoin
            )
            Utils.CoinType.BITCOIN_CASH.value -> CryptoBookDTO(
                book = coin,
                name = Utils.CoinType.BITCOIN_CASH.coin,
                minPrice = minPrice,
                maxPrice = maxPrice,
                logo = R.drawable.ic_bitcoin_cash
            )
            Utils.CoinType.TRUEUSD.value -> CryptoBookDTO(
                book = coin,
                name = Utils.CoinType.TRUEUSD.coin,
                minPrice = minPrice,
                maxPrice = maxPrice,
                logo = R.drawable.ic_trueusd
            )
            Utils.CoinType.DECETRALAND.value -> CryptoBookDTO(
                book = coin,
                name = Utils.CoinType.DECETRALAND.coin,
                minPrice = minPrice,
                maxPrice = maxPrice,
                logo = R.drawable.ic_decentraland_mana
            )
            Utils.CoinType.BASIC_ATENTION_TOKEN.value -> CryptoBookDTO(
                book = coin,
                name = Utils.CoinType.BASIC_ATENTION_TOKEN.coin,
                minPrice = minPrice,
                maxPrice = maxPrice,
                logo = R.drawable.ic_basic_attention_token_bat
            )
            Utils.CoinType.DAI.value -> CryptoBookDTO(
                book = coin,
                name = Utils.CoinType.DAI.name,
                minPrice = minPrice,
                maxPrice = maxPrice,
                logo = R.drawable.ic_dai
            )
            Utils.CoinType.USD_COIN.value -> CryptoBookDTO(
                book = coin,
                name = Utils.CoinType.USD_COIN.coin,
                minPrice = minPrice,
                maxPrice = maxPrice,
                logo = R.drawable.ic_usd
            )
            else -> CryptoBookDTO()
        }*/
}
