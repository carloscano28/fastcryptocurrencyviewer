package com.example.fastcryptocurrencyviewer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fastcryptocurrencyviewer.domain.AvailableBooksUseCase
import com.example.fastcryptocurrencyviewer.utils.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AvailableBooksVM (private val availableBooksUseCase: AvailableBooksUseCase):ViewModel() {

    // VARIABLES LIVE DATA
    private val _stateAvailableLD = MutableLiveData<Utils.AvailableBooksUiState>()
    val stateAvailableLD: LiveData<Utils.AvailableBooksUiState> = _stateAvailableLD

    // VARIABLES STATE FLOW
    private val _stateAvailable = MutableStateFlow(Utils.AvailableBooksUiState(isLoading = true))
    val state: StateFlow<Utils.AvailableBooksUiState> = _stateAvailable

    fun getAvailableBookInvoke(){
        viewModelScope.launch {
            val result = availableBooksUseCase.invoke()
            _stateAvailable.value = Utils.AvailableBooksUiState(isLoading = false, characters = result )
        }
    }
}

class AvailableBooksVMFactory(private val availableBooksUseCase: AvailableBooksUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AvailableBooksUseCase::class.java).newInstance(availableBooksUseCase)
    }
}