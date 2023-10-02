package com.mehedi.manualdiu.data

import com.mehedi.manualdiu.data.models.RequestLogin
import com.mehedi.manualdiu.data.models.register.RequestRegister
import com.mehedi.manualdiu.network.LoginService
import retrofit2.Retrofit
import javax.inject.Inject

class RemoteSource @Inject constructor(private val service: LoginService) {


    suspend fun loginUser(requestLogin: RequestLogin) = service.loginUser(requestLogin)
    suspend fun register(request: RequestRegister) = service.register(request)


}