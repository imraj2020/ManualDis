package com.mehedi.manualdiu.network

import com.mehedi.manualdiu.data.models.RequestLogin
import com.mehedi.manualdiu.data.models.ResponseLogin
import com.mehedi.manualdiu.data.models.register.RequestRegister
import com.mehedi.manualdiu.data.models.register.ResponseRegister
import com.mehedi.manualdiu.utils.LOGIN_ENDPOINT
import com.mehedi.manualdiu.utils.PROFILE_ENDPOINT
import com.mehedi.manualdiu.utils.PrefsManager
import com.mehedi.manualdiu.utils.REGISTER_ENDPOINT
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

import retrofit2.http.POST
import javax.inject.Inject

interface ApiService {


    @POST(LOGIN_ENDPOINT)
    suspend fun loginUser(@Body request: RequestLogin): Response<ResponseLogin>


    @POST(REGISTER_ENDPOINT)
    suspend fun register(@Body request: RequestRegister): Response<ResponseRegister>


    @GET(PROFILE_ENDPOINT)
    suspend fun profile(): Response<ResponseRegister>

}