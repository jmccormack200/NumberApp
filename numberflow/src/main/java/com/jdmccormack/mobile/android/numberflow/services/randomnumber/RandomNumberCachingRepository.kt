package com.jdmccormack.mobile.android.numberflow.services.randomnumber

import com.jdmccormack.mobile.android.commonui.SharedPreferencesManager
import com.jdmccormack.mobile.android.networking.Result

const val RANDOM_NUMBER_KEY = "NUMBER_FLOW_RANDOM_NUMBER_KEY"
const val DEFAULT_RANDOM_NUMBER = -1

class RandomNumberCachingRepository(
    private val randomNumberService: RandomNumberService = RandomNumberRetrofit.randomNumberService,
    private val sharedPreferencesManager: SharedPreferencesManager
) {
    suspend fun getRandomNumber(refresh: Boolean): Result<String, Number> {
        if (!refresh && getLocalRandomNumber() != DEFAULT_RANDOM_NUMBER) {
            return Result.Success(getLocalRandomNumber())
        }
        return getNewRandomNumber()
    }

    suspend fun getNewRandomNumber(): Result<String, Number> {
        return try {
            val result = randomNumberService.getRandomNumber(1, "uint8")
            if (result.success) {
                saveNumber(result.data[0])
                Result.Success(result.data[0])
            } else {
                Result.Failure("Call Failed")
            }
        } catch (e: Exception) {
            Result.Failure("Call Failed")
        }
    }

    private fun saveNumber(number: Number) {
        sharedPreferencesManager.preferences.edit().putInt(RANDOM_NUMBER_KEY, number.toInt())
            .apply()
    }

    private fun getLocalRandomNumber(): Number {
        return sharedPreferencesManager.preferences.getInt(
            RANDOM_NUMBER_KEY,
            DEFAULT_RANDOM_NUMBER
        )
    }
}
