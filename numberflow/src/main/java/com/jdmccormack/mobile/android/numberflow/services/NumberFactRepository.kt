package com.jdmccormack.mobile.android.numberflow.services

import com.jdmccormack.mobile.android.networking.Result
import com.jdmccormack.mobile.android.numberflow.services.models.NumberFact
import java.lang.Exception

class NumberFactRepository(
    private val numberFactService: NumberFactService = NumberFactRetrofit.numberFactService
) {
    suspend fun getFactAboutNumber(number: Number): Result<String, NumberFact> {
        try {
            val result = numberFactService.getFactAboutNumber(number);
            return Result.Success(result)
        } catch (e: Exception) {
            return Result.Failure("Call Failed")
        }
    }
}
