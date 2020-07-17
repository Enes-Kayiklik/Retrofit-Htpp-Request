package com.enes.retrofit.service

import com.enes.retrofit.model.Dog
import retrofit2.http.GET

interface RetrofitApi {
    @GET("api/breeds/image/random/10")
    suspend fun getDogData(): Dog
}