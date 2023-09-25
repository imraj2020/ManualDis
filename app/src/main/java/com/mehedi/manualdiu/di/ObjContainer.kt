package com.mehedi.manualdiu.di

import com.mehedi.manualdiu.data.LocalSource
import com.mehedi.manualdiu.data.RemoteSource
import com.mehedi.manualdiu.network.LoginService
import com.mehedi.manualdiu.repos.UserRepo
import com.mehedi.manualdiu.ui.MainViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ObjContainer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.escuelajs.co/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(LoginService::class.java)

    private val remoteSource = RemoteSource(retrofit)
    private val localSource = LocalSource()

    val userRepo = UserRepo(localSource, remoteSource)




}