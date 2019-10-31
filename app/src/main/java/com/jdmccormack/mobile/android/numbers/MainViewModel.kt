package com.jdmccormack.mobile.android.numbers

import com.jdmccormack.mobile.android.commonui.navigation.NavigationViewModel
import com.jdmccormack.mobile.android.numberflow.screens.LandingDestination

class MainViewModel: NavigationViewModel() {
    internal fun mainNavigateBtnClicked() {
        navigateTo(LandingDestination())
    }
}
