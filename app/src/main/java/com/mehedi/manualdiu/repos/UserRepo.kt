package com.mehedi.manualdiu.repos

import com.mehedi.manualdiu.data.LocalSource
import com.mehedi.manualdiu.data.RemoteSource
import com.mehedi.manualdiu.data.models.RequestLogin

class UserRepo(
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource

) {

    suspend fun loginUser(requestLogin: RequestLogin) = remoteSource.loginUser(requestLogin)


}