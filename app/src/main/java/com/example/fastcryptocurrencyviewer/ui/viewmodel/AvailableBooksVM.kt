package com.example.fastcryptocurrencyviewer.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fastcryptocurrencyviewer.data.domain.AvailableBooksUseCase
import com.example.fastcryptocurrencyviewer.utils.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AvailableBooksVM @Inject constructor(private val availableBooksUseCase: AvailableBooksUseCase):ViewModel() {

    private val _stateAvailable = MutableStateFlow(Utils.AvailableBooksUiState(isLoading = true))
    val state: StateFlow<Utils.AvailableBooksUiState> = _stateAvailable

    fun getAvailableBookInvoke(){
        viewModelScope.launch {
            val result = availableBooksUseCase.invoke()
            _stateAvailable.update {
                Utils.AvailableBooksUiState(isLoading = false, characters = result )
            }
        }
    }
}