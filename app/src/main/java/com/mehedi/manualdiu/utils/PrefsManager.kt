package com.mehedi.manualdiu.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PrefsManager @Inject constructor(@ApplicationContext context: Context) {

    private val pref = context.getSharedPreferences("auth-pref", Context.MODE_PRIVATE)


    fun setPref(key: String, value: String) {
        val editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getPref(key: String): String {

        return pref.getString(key, "").toString()

    }


}