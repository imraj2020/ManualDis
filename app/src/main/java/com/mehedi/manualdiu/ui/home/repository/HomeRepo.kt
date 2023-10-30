package com.mehedi.manualdiu.ui.home.repository

import com.mehedi.manualdiu.base.BaseRepository
import com.mehedi.manualdiu.network.ApiService
import javax.inject.Inject

class HomeRepo @Inject constructor(
    private val service: ApiService
) : BaseRepository() {


    suspend fun getCategories() = safeApiCall { service.getCategories() }

//    suspend fun refreshToken(requestToken: RequestToken): Response<ResponseToken> =
//        remoteSource.refreshToken(requestToken)
//
//    suspend fun register(request: RequestRegister) = remoteSource.register(request)


}