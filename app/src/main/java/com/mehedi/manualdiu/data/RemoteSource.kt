package com.mehedi.manualdiu.data

import com.mehedi.manualdiu.data.models.RequestLogin
import com.mehedi.manualdiu.data.models.register.RequestRegister
import com.mehedi.manualdiu.data.models.register.ResponseRegister
import com.mehedi.manualdiu.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class RemoteSource @Inject constructor(private val service: ApiService) {


    suspend fun loginUser(requestLogin: RequestLogin) = service.loginUser(requestLogin)
    suspend fun register(request: RequestRegister) = service.register(request)
    suspend fun profile(): Response<ResponseRegister> = service.profile()


}