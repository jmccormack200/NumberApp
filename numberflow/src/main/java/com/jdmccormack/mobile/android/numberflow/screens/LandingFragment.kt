package com.jdmccormack.mobile.android.numberflow.screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import com.jdmccormack.mobile.android.commonui.base.BaseFragment
import com.jdmccormack.mobile.android.numberflow.R
import kotlinx.android.synthetic.main.numberflow_fragment_landing.*

class LandingFragment: BaseFragment() {

    private val viewModel by lazy {
        obtainViewModel {
            LandingViewModel(RandomNumberRepository())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureViewModel()
    }

    private fun configureViewModel() {
        viewModel.randomNumber.observe(this, Observer {
            randomNumber_displayPoint.text = it.toString()
        })
    }

    override val layoutResourceId = R.layout.numberflow_fragment_landing
}
