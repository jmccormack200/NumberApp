package com.jdmccormack.mobile.android.networking

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val CONNECTION_TIMEOUT = 30L
    private const val TIMBER_TAG = "HTTP"

    fun <T> createRestApi(baseUrl: String, service: Class<T>): T {
        val httpClient = newOkHttpClient()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(service)
    }

    private fun newOkHttpClient(): OkHttpClient =
//        TODO Add Logging Interceptor
        OkHttpClient.Builder()
            .readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .build()
}
