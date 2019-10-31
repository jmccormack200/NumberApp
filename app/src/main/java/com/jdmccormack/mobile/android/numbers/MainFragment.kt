package com.jdmccormack.mobile.android.numbers

import android.os.Bundle
import android.util.Log
import android.view.View
import com.jdmccormack.mobile.android.commonui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    override val layoutResourceId = R.layout.fragment_main

    private val viewModel by lazy {
        obtainViewModel {
            MainViewModel()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureUIListener()
        configureViewModel()
    }

    private fun configureUIListener() {
        main_navigateBtn.setOnClickListener {
            viewModel.mainNavigateBtnClicked()
        }
    }

    private fun configureViewModel() {
        configureNavigationListener(viewModel.navigationLiveDataField)
    }
}
