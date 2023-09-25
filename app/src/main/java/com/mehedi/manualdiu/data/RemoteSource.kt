package com.mehedi.manualdiu.data

import com.mehedi.manualdiu.data.models.RequestLogin
import com.mehedi.manualdiu.network.LoginService
import retrofit2.Retrofit

class RemoteSource(private val service: LoginService) {


    suspend fun loginUser(requestLogin: RequestLogin) = service.loginUser(requestLogin)


}