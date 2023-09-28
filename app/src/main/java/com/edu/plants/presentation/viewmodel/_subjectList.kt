package com.edu.plants.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.plants.data.common.Resource
import com.edu.plants.domain.use_case.PlantUseCase
import com.edu.plants.presentation.state.PlantState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlantViewModel @Inject constructor(private val plantUseCase: PlantUseCase) : ViewModel() {

    private var _plantList = mutableStateOf(PlantState())

    val plantList: State<PlantState> get() = _plantList

    fun getPlantList() {
        plantUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _plantList.value = PlantState(isLoading = true)
                }

                is Resource.Success -> {
                    _plantList.value = PlantState(isData = it.data)
                }

                is Resource.Error -> {
                    _plantList.value = PlantState(isError = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}