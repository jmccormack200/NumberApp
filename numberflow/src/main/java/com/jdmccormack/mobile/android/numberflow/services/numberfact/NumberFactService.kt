package com.jdmccormack.mobile.android.numberflow.services.numberfact

import com.jdmccormack.mobile.android.numberflow.services.models.NumberFactRaw
import retrofit2.http.GET
import retrofit2.http.Path

interface NumberFactService {
    @GET("{number}/trivia?json")
    suspend fun getFactAboutNumber(@Path("number") number: Number): NumberFactRaw
}
