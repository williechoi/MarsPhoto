package com.example.marsphotos.network

import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import retrofit2.http.GET
import okhttp3.MediaType

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL)
    .build()


interface MarsApiService {

    // tell Retrofit that this is a GET request, and the endpoint for this web service is `photos`
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

// This object is Singleton.
object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}