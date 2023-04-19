package com.example.fastcryptocurrencyviewer.utils

import android.app.AlertDialog
import android.content.Context
import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailable
import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse

object Utils {

    var dialog: AlertDialog? = null

    class CryptoConstants {
        companion object {
            const val BITSO_URL = "https://api.bitso.com/v3/"
            const val MXN = "mxn"
            const val ERROR = "An unexpected error occured"
            const val ASK = "ASK"
            const val BID = "BID"
        }
    }

    enum class CoinType(val value: String, val coin: String, val logo: Int) {
        /*BITCOIN("btc_mxn", "Bitcoin", R.drawable.ic_bitcoin),
        ETHEREUM("eth_mxn", "Ethereum", R.drawable.ic_ethereum),
        XRP("xrp_mxn", "XRP", R.drawable.ic_xrp),
        LITECOIN("ltc_mxn", "Litecoin", R.drawable.ic_litecoin),
        BITCOIN_CASH("bch_mxn", "Bitcoin Cash", R.drawable.ic_litecoin),
        TRUEUSD("tusd_mxn", "True USD", R.drawable.ic_litecoin),
        DECETRALAND("mana_mxn", "Decentraland", R.drawable.ic_litecoin),
        BASIC_ATENTION_TOKEN("bat_mxn", "Basic Attention Token", R.drawable.ic_litecoin),
        DAI("dai_mxn", "Dai", R.drawable.ic_litecoin),
        USD_COIN("usd_mxn", "USD coin", R.drawable.ic_litecoin)*/
    }

    fun errorDialog(activity: Context, msg: String) {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("ERROR").setMessage(msg)
        dialog = builder.create()
    }

}

data class AvailableBooksUiState(
    val isLoading: Boolean = true,
    val characters: List<CryptoAvailable> = emptyList(),
    val errorMessage: String? = null,
    val exception: Throwable? = null
)
sealed class Resource<T>(val data: T? = null, val uiText: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(uiText: String, data: T? = null) : Resource<T>(data, uiText)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}
