package com.jdmccormack.mobile.android.numberflow.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdmccormack.mobile.android.networking.Result
import com.jdmccormack.mobile.android.numberflow.services.NumberFactRepository
import com.jdmccormack.mobile.android.numberflow.services.RandomNumberCachingRepository
import kotlinx.coroutines.launch

class LandingViewModel(
    private val randomNumberRepository: RandomNumberCachingRepository,
    private val numberFactRepository: NumberFactRepository
) : ViewModel() {

    private val _randomNumber = MutableLiveData<Number>()
    val randomNumber: LiveData<Number> = _randomNumber

    private val _numberFact = MutableLiveData<String>()
    val numberFact: LiveData<String> = _numberFact

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _randomNumber.value = when (val result = randomNumberRepository.getRandomNumber()) {
                is Result.Failure -> 404
                is Result.Success -> result.value
            }
        }
    }

    //TODO Remove this function and the button and get the data on load.
    fun fetchFactBtnClicked() {
        viewModelScope.launch {
            _numberFact.value = when (val result = numberFactRepository.getFactAboutNumber(
                _randomNumber.value ?: 404
            )) {
                is Result.Failure -> "No Fact found"
                is Result.Success -> result.value.text
            }
        }
    }

    fun getNewRandomNumberClicked() {
        viewModelScope.launch {
            _randomNumber.value = when (val result = randomNumberRepository.getNewRandomNumber()) {
                is Result.Failure -> 404
                is Result.Success -> result.value
            }
        }
    }
}
