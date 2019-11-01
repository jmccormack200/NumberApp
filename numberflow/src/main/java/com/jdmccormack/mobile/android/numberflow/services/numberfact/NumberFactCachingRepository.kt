package com.jdmccormack.mobile.android.numberflow.services.numberfact

import com.jdmccormack.mobile.android.networking.Result
import com.jdmccormack.mobile.android.numberflow.services.models.NumberFact
import com.jdmccormack.mobile.android.numberflow.services.models.toNumberFact

class NumberFactCachingRepository(
    private val numberFactService: NumberFactService = NumberFactRetrofit.numberFactService,
    private val numberFactsDao: NumberFactsDao
) {
    suspend fun getFactAboutNumber(number: Number): Result<String, NumberFact> {
        try {
            val localNumberFact = getLocalFacts(number)
            if (localNumberFact != null) {
                return Result.Success(localNumberFact)
            }
            return Result.Success(getRemoteFacts(number))
        } catch (e: Exception) {
            return Result.Failure("Call Failed")
        }
    }

    // TODO MOVE Int back to number
    private suspend fun getLocalFacts(number: Number): NumberFact? {
        return numberFactsDao.getNumberFactByNumber(number.toInt())
    }

    private suspend fun getRemoteFacts(number: Number): NumberFact {
        val numberFact = numberFactService.getFactAboutNumber(number).toNumberFact()
        numberFactsDao.insertNumberFact(numberFact)
        return numberFact
    }
}
