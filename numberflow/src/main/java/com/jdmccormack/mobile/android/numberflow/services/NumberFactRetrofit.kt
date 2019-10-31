package com.jdmccormack.mobile.android.numberflow.services

import com.jdmccormack.mobile.android.networking.RetrofitClient

object NumberFactRetrofit {
    private const val BASE_URL = "http://numbersapi.com/"

    val numberFactService: NumberFactService by lazy {
        RetrofitClient.createRestApi(
            BASE_URL,
            NumberFactService::class.java
        )
    }
}
