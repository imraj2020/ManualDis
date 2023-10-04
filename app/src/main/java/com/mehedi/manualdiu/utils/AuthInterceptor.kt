package com.mehedi.manualdiu.utils

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val prefsManager: PrefsManager) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request().newBuilder()

        request.addHeader("Authorization", "Bearer ${prefsManager.getPref(KEY_ACCESS)}")

        return chain.proceed(request.build())


    }
}