package com.jdmccormack.mobile.android.numberflow.screens

import android.util.Log
import com.jdmccormack.mobile.android.networking.Result
import com.jdmccormack.mobile.android.numberflow.screens.services.RandomNumber
import com.jdmccormack.mobile.android.numberflow.screens.services.RandomNumberRetrofit
import com.jdmccormack.mobile.android.numberflow.screens.services.RandomNumberService
import java.lang.Exception

class RandomNumberRepository(
    private val randomNumberService: RandomNumberService = RandomNumberRetrofit.randomNumberService
) {
    suspend fun getRandomNumber(): Result<String, RandomNumber> {
        Log.e("GRN", "Calling it now")
        try {
            val result = randomNumberService.getRandomNumberAsync(1, "uint8")
            Log.e("result", result.toString())
            if (result.success) {
                return Result.Success(result)
            } else {
                return Result.Failure("Call Failed")
            }
        } catch (e: Exception) {
            Log.e("Exception", e.message)
            return Result.Failure("Call Failed")
        }
    }
}
