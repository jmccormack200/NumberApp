package com.jdmccormack.mobile.android.commonui.navigation

import android.os.Bundle

open class NavigationDestination(
    private val id: Int,
    private val navigationArguments: Bundle? = null
) {
    /**
     * Generates a navigation event from the [id] and [navigationArguments] of the
     * [NavigationDestination] class.
     */
    fun buildEvent(): NavigationEvent = NavigationEvent(id, navigationArguments)
}
