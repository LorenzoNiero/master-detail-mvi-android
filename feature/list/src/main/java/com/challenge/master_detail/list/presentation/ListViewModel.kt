package com.challenge.master_detail.list.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.master_detail.domain.usecase.GetMediasUseCase
import com.challenge.master_detail.navigator.Navigator
import com.challenge.master_detail.navigator.destination.DetailNavigationDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val navigator: Navigator,
    private val getMediasUseCase : GetMediasUseCase
) : ViewModel(), Navigator by navigator {

    private val _uiState = MutableStateFlow<ListUiState>(ListUiState.Loading)
    val uiState: StateFlow<ListUiState> by lazy { _uiState.asStateFlow() }

    init {
        refreshList()
    }

    private fun refreshList() {
        viewModelScope.launch {
            fetchMedias()
        }
    }

    private suspend fun fetchMedias() {
        _uiState.value = ListUiState.Loading

        withContext(Dispatchers.IO){

            getMediasUseCase().onSuccess { result ->
                when {
                    result.isEmpty() -> {
                        _uiState.value = ListUiState.Empty
                    }
                    else -> {
                        _uiState.value = ListUiState.Result(result)
                    }
                }
            }.onFailure { throwable ->
                _uiState.value = ListUiState.Error(throwable.message)
            }
        }
    }

    fun navigateToDetail() {
        navigator.navigate(DetailNavigationDestination)
    }

}



