package com.jdmccormack.mobile.android.numberflow.screens.services

import com.jdmccormack.mobile.android.networking.RetrofitClient

object RandomNumberRetrofit {
    private const val BASE_URL = "http://qrng.anu.edu.au/API/"

    val randomNumberService: RandomNumberService by lazy {
        RetrofitClient.createRestApi(
            BASE_URL,
            RandomNumberService::class.java
        )
    }
}
