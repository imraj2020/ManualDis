package com.mehedi.manualdiu.di

import android.content.Context
import com.mehedi.baselib.NativeLib
import com.mehedi.manualdiu.data.LocalSource
import com.mehedi.manualdiu.network.ApiService
import com.mehedi.manualdiu.repos.UserRepo
import com.mehedi.manualdiu.utils.AuthInterceptor
import com.mehedi.manualdiu.utils.PrefsManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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


//    @Provides
//    @Singleton
//    fun remoteSource(retrofit: ApiService) = RemoteSource(retrofit)

    @Provides
    @Singleton
    fun localSource() = LocalSource()

    @Provides
    @Singleton
    fun userRepo(localSource: LocalSource, service: ApiService) =
        UserRepo(localSource, service)


    @Provides
    @Singleton
    fun providePrefs(@ApplicationContext context: Context) = PrefsManager(context)

    @Provides
    @Singleton
    fun provideHttpClient(interceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun retrofit(baseUrl: String, interceptorClient: OkHttpClient): ApiService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(interceptorClient)
        .build().create(ApiService::class.java)

}