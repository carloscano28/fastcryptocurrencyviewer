package com.example.fastcryptocurrencyviewer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fastcryptocurrencyviewer.data.api.BitsoApiService
import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailable
import com.example.fastcryptocurrencyviewer.data.model.CryptoAvailableResponse
import com.example.fastcryptocurrencyviewer.utils.*
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class AvailableBooksVM (private val client: AvailableBooksClient):ViewModel() {

    private val _stateAvailable = MutableStateFlow(Utils.AvailableBooksUiState(isLoading = true))
    val state: StateFlow<Utils.AvailableBooksUiState> = _stateAvailable


    fun getAvailableBook(){
        viewModelScope.launch(Dispatchers.IO) {

            client.getCharacters().onSuccess {

            }.onError{ code, message ->

            }.onException {  }

            _stateAvailable.value = when(val result = client.getCharacters()) {
                is ApiSuccess -> Utils.AvailableBooksUiState(
                    isLoading = false,
                    characters = result.data.coins!!.filter{coin->coin.coin.contains(Utils.CryptoConstants.MXN)}
                )
                is ApiException -> Utils.AvailableBooksUiState(exception = result.e)
                is ApiError -> Utils.AvailableBooksUiState(errorMessage = result.message)
            }

        }
    }
    fun getAvailableBookRx() {
        viewModelScope.launch {
            client.getAllCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { onSuccess, onError ->
                    onSuccess?.let {
                        if (it.isSuccessful){
                            it.body()?.coins.let {
                                if (it != null) {
                                    _stateAvailable.value = Utils.AvailableBooksUiState(
                                        isLoading = false,
                                        characters = it
                                            .filter{coin->coin.coin.contains(
                                                Utils.CryptoConstants.MXN)
                                            }
                                    )
                                }
                            }

                        }

                    }

                    onError?.let{
                        _stateAvailable.value = Utils.AvailableBooksUiState(isLoading = false, characters = emptyList() )
                    }
                }
        }
    }
}

class AvailableBooksVMFactory(private val myClient: AvailableBooksClient): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AvailableBooksClient::class.java).newInstance(myClient)
    }
}


class AvailableBooksClient(private val apiService: BitsoApiService) {

    suspend fun getCharacters(): NetworkResult<CryptoAvailableResponse> =
        handleApi { apiService.getAvailableBooks() }
    fun getAllCharacters(): Single<Response<CryptoAvailableResponse>> = apiService.getExchangeBooksRx()

}
