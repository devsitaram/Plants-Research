package com.edu.plants.data.source.remote.network

import com.edu.plants.data.source.remote.pojo.PlantList
import retrofit2.http.GET

interface ApiServices {

    @GET("article-faq-list?key=sk-oxO265152d3abe4a52293")
    suspend fun getPlantList(): PlantList?

    @GET("species/details/[ID]?key=sk-oxO265152d3abe4a52293")
    suspend fun getPlantDetailsById()


}