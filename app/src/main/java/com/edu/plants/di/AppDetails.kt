package com.edu.plants.di

import com.edu.plants.domain.repository.PlantRepository
import com.edu.plants.domain.use_case.PlantUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppDetails {

    @Provides
    @Singleton
    fun providePlantUseCase(plantRepository: PlantRepository): PlantUseCase {
        return PlantUseCase(plantRepository)
    }
}