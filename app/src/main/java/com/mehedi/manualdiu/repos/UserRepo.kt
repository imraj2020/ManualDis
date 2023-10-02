package com.mehedi.manualdiu.repos

import com.mehedi.manualdiu.data.LocalSource
import com.mehedi.manualdiu.data.RemoteSource
import com.mehedi.manualdiu.data.models.RequestLogin
import com.mehedi.manualdiu.data.models.register.RequestRegister
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource

) {

    suspend fun loginUser(requestLogin: RequestLogin) = remoteSource.loginUser(requestLogin)
    suspend fun register(request: RequestRegister) = remoteSource.register(request)


}