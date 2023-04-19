package com.example.fastcryptocurrencyviewer.ui.viewmodel

import androidx.lifecycle.*
import com.example.fastcryptocurrencyviewer.data.domain.AvailableBooksUseCase
import com.example.fastcryptocurrencyviewer.utils.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class AvailableBooksVM @Inject constructor(private val availableBooksUseCase: AvailableBooksUseCase):ViewModel() {

    // VARIABLES LIVE DATA
    private val _stateAvailableLD = MutableLiveData<AvailableBooksUiState>()
    val stateAvailableLD: LiveData<AvailableBooksUiState> = _stateAvailableLD

    fun getAvailableBookLiveData() = liveData(viewModelScope.coroutineContext + Dispatchers.Main){

        try {
            emit(
                AvailableBooksUiState(
                        isLoading = false,
                        characters = availableBooksUseCase()
                    )
            )
        }catch (e:Exception){
            emit(
                AvailableBooksUiState(
                        errorMessage = e.localizedMessage ?: Utils.CryptoConstants.ERROR
                    )
            )
        }
    }

    /*fun getAvailableBookInvoke(){
        viewModelScope.launch {
            val result = availableBooksUseCase.invoke()
            _stateAvailableLD.value = Utils.AvailableBooksUiState(isLoading = false, characters = result )
        }
    }*/

}