package com.droidcon.sduicompsemvvm.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcon.sduicompsemvvm.data.repository.HomeRepository
import com.droidcon.sduicompsemvvm.model.Component
import com.droidcon.sduicompsemvvm.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _componentStateFlow = MutableStateFlow<UiState<List<Component>>>(UiState.Loading)
    val componentStateFlow: StateFlow<UiState<List<Component>>> = _componentStateFlow

    fun onGetHomeComponents() {
        viewModelScope.launch {
            delay(2000)
             homeRepository.getHomeComponents()
                 .onSuccess {
                   _componentStateFlow.value = UiState.Success(it)
                 }
                 .onFailure {
                     _componentStateFlow.value = UiState.Error(it)
                 }
        }
    }
}