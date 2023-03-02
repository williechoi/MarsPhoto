package com.example.marsphotos.network

import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import retrofit2.http.GET
import okhttp3.MediaType


interface MarsApiService {

    // tell Retrofit that this is a GET request, and the endpoint for this web service is `photos`
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
