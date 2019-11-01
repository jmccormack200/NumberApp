package com.jdmccormack.mobile.android.numberflow.services.usecases

import com.jdmccormack.mobile.android.networking.Result
import com.jdmccormack.mobile.android.numberflow.services.numberfact.NumberFactCachingRepository
import com.jdmccormack.mobile.android.numberflow.services.randomnumber.RandomNumberCachingRepository
import com.jdmccormack.mobile.android.numberflow.services.models.NumberFact

class GetNumberUseCase(
    private val numberFactRepository: NumberFactCachingRepository,
    private val randomNumberCachingRepository: RandomNumberCachingRepository
) {
    suspend fun invoke(refresh: Boolean = false): Result<String, NumberFact> {
        val randomNumberResult = randomNumberCachingRepository.getRandomNumber(refresh)
        return when (randomNumberResult) {
            is Result.Failure -> randomNumberResult
            is Result.Success -> numberFactRepository.getFactAboutNumber(randomNumberResult.value)
        }
    }
}
