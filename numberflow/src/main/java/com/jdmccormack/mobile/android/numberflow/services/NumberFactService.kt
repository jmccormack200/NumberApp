package com.jdmccormack.mobile.android.numberflow.services

import com.jdmccormack.mobile.android.numberflow.services.models.NumberFact
import retrofit2.http.GET
import retrofit2.http.Path

interface NumberFactService {
    @GET("{number}/trivia?json")
    suspend fun getFactAboutNumber(@Path("number") number: Number): NumberFact
}
