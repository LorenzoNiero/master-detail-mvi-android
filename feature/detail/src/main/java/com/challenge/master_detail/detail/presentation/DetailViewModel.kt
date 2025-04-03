package com.challenge.master_detail.detail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.master_detail.navigator.destination.DetailNavigationDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _uiState.value = DetailUiState.Error(throwable.message)
    }

    private val _uiState = MutableStateFlow<DetailUiState>( DetailUiState.Loading )
    val uiState: StateFlow<DetailUiState> by lazy { _uiState.asStateFlow() }

    init {
        viewModelScope.launch(exceptionHandler) {
            _uiState.value = DetailUiState.Detail(
                media = DetailNavigationDestination.decodeParam(savedStateHandle)
            )
        }
    }

}

