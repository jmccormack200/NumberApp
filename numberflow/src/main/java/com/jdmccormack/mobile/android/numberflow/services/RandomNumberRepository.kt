package com.jdmccormack.mobile.android.numberflow.services

import com.jdmccormack.mobile.android.networking.Result
import com.jdmccormack.mobile.android.numberflow.services.models.RandomNumber
import com.jdmccormack.mobile.android.numberflow.screens.services.RandomNumberRetrofit
import com.jdmccormack.mobile.android.numberflow.screens.services.RandomNumberService
import java.lang.Exception

class RandomNumberRepository(
    private val randomNumberService: RandomNumberService = RandomNumberRetrofit.randomNumberService
) {
    suspend fun getRandomNumber(): Result<String, RandomNumber> {
        try {
            val result = randomNumberService.getRandomNumberAsync(1, "uint8")
            if (result.success) {
                return Result.Success(result)
            } else {
                return Result.Failure("Call Failed")
            }
        } catch (e: Exception) {
            return Result.Failure("Call Failed")
        }
    }
}
