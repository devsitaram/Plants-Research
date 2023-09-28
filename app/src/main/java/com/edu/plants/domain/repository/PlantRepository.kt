package com.edu.plants.domain.repository

import com.edu.plants.data.source.remote.pojo.PlantItem

interface PlantRepository {

    suspend fun getPlantList(): List<PlantItem?>?

}