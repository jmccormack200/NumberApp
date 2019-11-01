package com.jdmccormack.mobile.android.numberflow.services.randomnumber

import com.jdmccormack.mobile.android.numberflow.services.models.RandomNumber
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomNumberService {
    @GET("jsonI.php")
    suspend fun getRandomNumber(@Query("length") length: Number, @Query("type") type: String): RandomNumber
}
