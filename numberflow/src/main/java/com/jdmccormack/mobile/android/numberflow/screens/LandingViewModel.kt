package com.jdmccormack.mobile.android.numberflow.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdmccormack.mobile.android.networking.Result
import kotlinx.coroutines.launch

class LandingViewModel(
    private val randomNumberRepository: RandomNumberRepository
) : ViewModel() {

    private val _randomNumber = MutableLiveData<Number>()
    val randomNumber: LiveData<Number> = _randomNumber

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _randomNumber.value = when (val result = randomNumberRepository.getRandomNumber()) {
                is Result.Failure -> 404
                is Result.Success -> result.value.data[0]
            }
        }
    }
}
