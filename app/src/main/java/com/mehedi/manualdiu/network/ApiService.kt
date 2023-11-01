package com.mehedi.manualdiu.network

import com.mehedi.manualdiu.data.models.login.RequestLogin
import com.mehedi.manualdiu.data.models.register.RequestRegister
import com.mehedi.manualdiu.data.models.register.ResponseRegister
import com.mehedi.manualdiu.data.models.token.RequestToken
import com.mehedi.manualdiu.data.models.token.ResponseToken
import com.mehedi.manualdiu.utils.CATEGORY_ENDPOINT
import com.mehedi.manualdiu.utils.LOGIN_ENDPOINT
import com.mehedi.manualdiu.utils.PRODUCT_BY_CATEGORY_ENDPOINT
import com.mehedi.manualdiu.utils.PROFILE_ENDPOINT
import com.mehedi.manualdiu.utils.REGISTER_ENDPOINT
import com.mehedi.manualdiu.utils.TOKEN_ENDPOINT
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST(LOGIN_ENDPOINT)
    suspend fun loginUser(@Body request: RequestLogin): Response<ResponseBody>


    @POST(REGISTER_ENDPOINT)
    suspend fun register(@Body request: RequestRegister): Response<ResponseRegister>


    @GET(PROFILE_ENDPOINT)
    suspend fun profile(): Response<ResponseBody>

    @GET(CATEGORY_ENDPOINT)
    suspend fun getCategories(): Response<ResponseBody>

    @GET(PRODUCT_BY_CATEGORY_ENDPOINT)
    suspend fun getProductByCategory(@Path("id") id: Int): Response<ResponseBody>

    @POST(TOKEN_ENDPOINT)
    suspend fun refreshToken(@Body requestToken: RequestToken): Response<ResponseToken>

}