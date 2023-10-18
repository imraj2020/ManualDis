package com.mehedi.manualdiu.repos

import com.mehedi.manualdiu.base.BaseRepository
import com.mehedi.manualdiu.data.LocalSource
import com.mehedi.manualdiu.data.RemoteSource
import com.mehedi.manualdiu.data.models.login.RequestLogin
import com.mehedi.manualdiu.data.models.register.RequestRegister
import com.mehedi.manualdiu.data.models.register.ResponseRegister
import com.mehedi.manualdiu.data.models.token.RequestToken
import com.mehedi.manualdiu.data.models.token.ResponseToken
import com.mehedi.manualdiu.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource,
    private val service: ApiService
) : BaseRepository() {

    suspend fun loginUser(requestLogin: RequestLogin) =
        safeApiCall { service.loginUser(requestLogin) }


    suspend fun register(request: RequestRegister) = remoteSource.register(request)
    suspend fun profile(): Response<ResponseRegister> = remoteSource.profile()

    suspend fun refreshToken(requestToken: RequestToken): Response<ResponseToken> =
        remoteSource.refreshToken(requestToken)


}