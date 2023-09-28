package com.edu.plants.domain.use_case

import com.edu.plants.data.common.Resource
import com.edu.plants.data.source.remote.pojo.PlantItem
import com.edu.plants.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class PlantUseCase(private val plantRepository: PlantRepository) {

    operator fun invoke(): Flow<Resource<List<PlantItem?>?>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = plantRepository.getPlantList()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }

}