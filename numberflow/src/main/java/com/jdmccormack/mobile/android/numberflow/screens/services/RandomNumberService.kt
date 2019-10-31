package com.jdmccormack.mobile.android.numberflow.screens.services

import retrofit2.http.GET
import retrofit2.http.Query

interface RandomNumberService {
    @GET("jsonI.php")
    suspend fun getRandomNumberAsync(@Query("length") length: Number, @Query("type") type: String): RandomNumber
}
