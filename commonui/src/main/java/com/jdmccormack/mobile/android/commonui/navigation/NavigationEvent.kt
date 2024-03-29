package com.jdmccormack.mobile.android.commonui.navigation

import android.net.Uri
import android.os.Bundle
import androidx.annotation.IdRes

/**
 * Class to wrap the navigation ID and appropriate arguments that need to be in the bundle while switching between fragments.
 *
 * @param navId = the ID to navigate too
 * @param navigationArguments: The Map of keys to values of various parameters that need to be passed into the next screen.
 */
data class NavigationEvent(@IdRes val navId: Int, val navigationArguments: Bundle? = null) {
}
