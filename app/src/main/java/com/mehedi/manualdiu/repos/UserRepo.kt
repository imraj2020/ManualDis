package com.mehedi.manualdiu.repos

import com.mehedi.manualdiu.base.BaseRepository
import com.mehedi.manualdiu.data.LocalSource
import com.mehedi.manualdiu.data.models.login.RequestLogin
import com.mehedi.manualdiu.network.ApiService
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val localSource: LocalSource,
  //  private val remoteSource: RemoteSource,
    private val service: ApiService
) : BaseRepository() {

    suspend fun loginUser(requestLogin: RequestLogin) =
        safeApiCall { service.loginUser(requestLogin) }

    suspend fun profile() = safeApiCall { service.profile() }

//    suspend fun refreshToken(requestToken: RequestToken): Response<ResponseToken> =
//        remoteSource.refreshToken(requestToken)
//
//    suspend fun register(request: RequestRegister) = remoteSource.register(request)


}