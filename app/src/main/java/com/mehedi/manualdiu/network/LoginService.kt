package com.mehedi.manualdiu.network

import com.mehedi.manualdiu.data.models.RequestLogin
import com.mehedi.manualdiu.data.models.ResponseLogin
import com.mehedi.manualdiu.data.models.register.RequestRegister
import com.mehedi.manualdiu.data.models.register.ResponseRegister
import com.mehedi.manualdiu.utils.LOGIN_ENDPOINT
import com.mehedi.manualdiu.utils.REGISTER_ENDPOINT
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.POST

interface LoginService {


    @POST(LOGIN_ENDPOINT)
    suspend fun loginUser(@Body request: RequestLogin): Response<ResponseLogin>


    @POST(REGISTER_ENDPOINT)
    suspend fun register(@Body request: RequestRegister): Response<ResponseRegister>

}