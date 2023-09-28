package com.edu.plants.presentation.state

import com.edu.plants.data.source.remote.pojo.PlantItem

class PlantState(
    val isLoading: Boolean = false,
    val isData: List<PlantItem?>? = null,
    val isError: String = ""
)