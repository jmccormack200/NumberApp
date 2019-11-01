package com.jdmccormack.mobile.android.numberflow.screens

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.jdmccormack.mobile.android.commonui.SharedPreferencesManager
import com.jdmccormack.mobile.android.commonui.base.BaseFragment
import com.jdmccormack.mobile.android.numberflow.R
import com.jdmccormack.mobile.android.numberflow.services.NumberFlowDatabase
import com.jdmccormack.mobile.android.numberflow.services.numberfact.NumberFactCachingRepository
import com.jdmccormack.mobile.android.numberflow.services.randomnumber.RandomNumberCachingRepository
import com.jdmccormack.mobile.android.numberflow.services.usecases.GetNumberUseCase
import kotlinx.android.synthetic.main.numberflow_fragment_landing.*

class LandingFragment : BaseFragment() {

//    TODO: can we avoid the !! ?
    private val viewModel by lazy {
        obtainViewModel {
            LandingViewModel(
                GetNumberUseCase(
                    NumberFactCachingRepository(
                        numberFactsDao = NumberFlowDatabase.getNumberFlowDatabase(application!!.applicationContext)!!.numberFactsDao()
                    ),
                    RandomNumberCachingRepository(
                        sharedPreferencesManager = SharedPreferencesManager.getInstance(
                            requireContext()
                        )
                    )
                )
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureViewModel()
        configureUI()
    }

    private fun configureUI() {
        regenerateBtn.setOnClickListener {
            viewModel.getNewRandomNumberClicked()
        }
    }

    private fun configureViewModel() {
        viewModel.randomNumber.observe(this, Observer {
            randomNumber_displayPoint.text = it.toString()
        })
        viewModel.numberFact.observe(this, Observer {
            number_fact.text = it
        })
    }

    override val layoutResourceId = R.layout.numberflow_fragment_landing
}
