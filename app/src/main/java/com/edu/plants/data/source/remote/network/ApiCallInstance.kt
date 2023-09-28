package com.edu.plants.data.source.remote.network

import android.content.Context
import com.edu.plants.data.common.Constants.API_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCallInstance {

    companion object {
        fun getRetrofitInstance(context: Context): Retrofit {
            // create the object of httpLoggingInterceptor
            val httpLoggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            // create object of okHttpClient
            val okHttpClient =
                OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor).build()
//                    .addInterceptor(ClientInterceptors(context)) // Add the custom interceptor
//                    .build() // addInterceptor() header
            // return the retrofit
            return Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()) // converter
                .build()
        }
    }
}