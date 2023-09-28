package com.edu.plants.di

import android.content.Context
import com.edu.plants.data.repository_impl.PlantRepositoryImpl
import com.edu.plants.data.source.remote.network.ApiCallInstance.Companion.getRetrofitInstance
import com.edu.plants.data.source.remote.network.ApiServices
import com.edu.plants.domain.repository.PlantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiRetrofitInstance(@ApplicationContext context: Context): ApiServices {
        // get subject retrofit instance mst
        return getRetrofitInstance(context).create(ApiServices::class.java)
    }

    @Provides
    @Singleton
    fun providePlantRepoImpl(apiServices: ApiServices): PlantRepository {
        return PlantRepositoryImpl(apiServices)
    }
}