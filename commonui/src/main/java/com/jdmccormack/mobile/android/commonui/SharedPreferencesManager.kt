package com.jdmccormack.mobile.android.commonui

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SharedPreferencesManager constructor(context: Context) {
    val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    companion object {
        private var instance: SharedPreferencesManager? = null
        fun getInstance(context: Context): SharedPreferencesManager {
            return instance ?: SharedPreferencesManager(context).apply { instance = this }
        }
    }
}
