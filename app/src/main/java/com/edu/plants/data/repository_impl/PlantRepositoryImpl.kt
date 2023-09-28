package com.edu.plants.data.repository_impl

import com.edu.plants.data.source.remote.network.ApiServices
import com.edu.plants.data.source.remote.pojo.PlantItem
import com.edu.plants.domain.repository.PlantRepository

class PlantRepositoryImpl(private val apiServices: ApiServices) : PlantRepository {

    override suspend fun getPlantList(): List<PlantItem?>? {
        return apiServices.getPlantList()?.data?.map { it }
    }
}