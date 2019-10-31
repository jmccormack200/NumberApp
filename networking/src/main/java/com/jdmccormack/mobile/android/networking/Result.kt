package com.jdmccormack.mobile.android.networking

import com.jdmccormack.mobile.android.commonui.StringResource

sealed class Result<out E, out T> {
    data class Success<out T>(val value: T) : Result<Nothing, T>()
    data class Failure<out E>(val error: E) : Result<E, Nothing>()
}

fun <E, T, T2> Result<E, T>.map(function: (T) -> (T2)): Result<E, T2> = when (this) {
    is Result.Success -> Result.Success(function(value))
    is Result.Failure -> this
}

fun <E, E2, T> Result<E, T>.mapError(function: (E) -> (E2)): Result<E2, T> = when (this) {
    is Result.Success -> this
    is Result.Failure -> Result.Failure(function(error))
}

fun Result<StringResource, StringResource>.toDisplayResult(): StringResource {
    return when (this) {
        is Result.Failure -> error
        is Result.Success -> value
    }
}
