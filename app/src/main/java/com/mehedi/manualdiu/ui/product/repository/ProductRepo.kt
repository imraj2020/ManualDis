package com.mehedi.manualdiu.ui.product.repository

import com.mehedi.manualdiu.base.BaseRepository
import com.mehedi.manualdiu.network.ApiService
import javax.inject.Inject

class ProductRepo @Inject constructor(
    private val service: ApiService
) : BaseRepository() {


    suspend fun getProductByCategory(id: Int) = safeApiCall { service.getProductByCategory(id) }

//    suspend fun refreshToken(requestToken: RequestToken): Response<ResponseToken> =
//        remoteSource.refreshToken(requestToken)
//
//    suspend fun register(request: RequestRegister) = remoteSource.register(request)


}