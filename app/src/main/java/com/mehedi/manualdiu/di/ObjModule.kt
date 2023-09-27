package com.mehedi.manualdiu.di

import com.mehedi.manualdiu.data.LocalSource
import com.mehedi.manualdiu.data.RemoteSource
import com.mehedi.manualdiu.network.LoginService
import com.mehedi.manualdiu.repos.UserRepo
import com.mehedi.baselib.NativeLib
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ObjModule {

    @Provides
    @Singleton
    fun urlProvides(): String {
        return NativeLib().stringFromJNI()
    }


    @Provides
    @Singleton
    fun retrofit(baseUrl: String): LoginService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(LoginService::class.java)

    @Provides
    @Singleton
    fun remoteSource(retrofit: LoginService) = RemoteSource(retrofit)

    @Provides
    @Singleton
    fun localSource() = LocalSource()

    @Provides
    @Singleton
    fun userRepo(localSource: LocalSource, remoteSource: RemoteSource) =
        UserRepo(localSource, remoteSource)


}