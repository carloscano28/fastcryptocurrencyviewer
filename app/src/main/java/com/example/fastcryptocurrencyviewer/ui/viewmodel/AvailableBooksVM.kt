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
    private val _stateAvailableLD = MutableLiveData<Utils.AvailableBooksUiState>()
    val stateAvailableLD: LiveData<Utils.AvailableBooksUiState> = _stateAvailableLD

    fun getAvailableBookLiveData() = liveData(viewModelScope.coroutineContext + Dispatchers.Main){

        try {
            emit(
                Utils
                    .AvailableBooksUiState(
                        isLoading = false,
                        characters = availableBooksUseCase.invoke()
                    )
            )
        }catch (e:Exception){
            emit(
                Utils
                    .AvailableBooksUiState(
                        exception = e
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