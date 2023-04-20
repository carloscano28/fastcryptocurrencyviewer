package com.example.fastcryptocurrencyviewer.ui.viewmodel

import androidx.lifecycle.*
import com.example.fastcryptocurrencyviewer.domain.AvailableBooksUseCase
import com.example.fastcryptocurrencyviewer.utils.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AvailableBooksVM @Inject constructor(private val availableBooksUseCase: AvailableBooksUseCase):ViewModel() {

    private val _stateAvailable = MutableStateFlow(AvailableBooksUiState(isLoading = true))
    val state: StateFlow<AvailableBooksUiState> = _stateAvailable


    fun getAvailableBookInvoke(){
        viewModelScope.launch {
            val result = availableBooksUseCase()
            result.onEach { crypto ->
                when(crypto){
                    is Resource.Loading -> {
                        _stateAvailable.update {
                            it.copy(isLoading = true)
                        }
                    }
                    is Resource.Success -> {
                        _stateAvailable.update {
                            it.copy(
                                isLoading = false,
                                characters = crypto.data!!
                            )
                        }
                    }
                    is Resource.Error -> {
                        _stateAvailable.update {
                            it.copy(isLoading = false, errorMessage = crypto.uiText  )
                        }
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}