package com.jdmccormack.mobile.android.numberflow.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdmccormack.mobile.android.networking.Result
import com.jdmccormack.mobile.android.numberflow.services.models.NumberFact
import com.jdmccormack.mobile.android.numberflow.services.usecases.GetNumberUseCase
import kotlinx.coroutines.launch

class LandingViewModel(
    private val getNumberUseCase: GetNumberUseCase
) : ViewModel() {

    private val _randomNumber = MutableLiveData<Number>()
    val randomNumber: LiveData<Number> = _randomNumber

    private val _numberFact = MutableLiveData<String>()
    val numberFact: LiveData<String> = _numberFact

    init {
        fetchData()
    }

    private fun fetchData() {
        getNumber()
    }

    fun getNewRandomNumberClicked() {
        getNumber(true)
    }

    private fun getNumber(refresh: Boolean = false) {
        viewModelScope.launch {
            val result = when (val result = getNumberUseCase.invoke(refresh)) {
                is Result.Failure -> NumberFact(404, "Error")
                is Result.Success -> result.value
            }
            _randomNumber.value = result.number
            _numberFact.value = result.text
        }
    }
 }
