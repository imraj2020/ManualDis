package com.mehedi.manualdiu.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.manualdiu.core.DataState
import com.mehedi.manualdiu.core.NetworkState
import com.mehedi.manualdiu.data.models.login.RequestLogin
import com.mehedi.manualdiu.data.models.token.RequestToken
import com.mehedi.manualdiu.data.models.token.ResponseToken
import com.mehedi.manualdiu.repos.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: UserRepo) : ViewModel() {

    private var _loginResponse = MutableLiveData<DataState<Response<ResponseBody>>>()
    val loginResponse: LiveData<DataState<Response<ResponseBody>>> = _loginResponse


    fun loginUser(requestLogin: RequestLogin) {
        _loginResponse.postValue(DataState.Loading)

        viewModelScope.launch {

            val response = repo.loginUser(requestLogin)

            _loginResponse.postValue(response)


            Log.d("TAG", "loginUser: $response ")


        }


    }

    private var _refreshTokenResponse = MutableLiveData<NetworkState<ResponseToken>>()
    val refreshTokenResponse: LiveData<NetworkState<ResponseToken>> = _refreshTokenResponse
    fun refreshToken(request: RequestToken) {
        _refreshTokenResponse.postValue(NetworkState.Loading())

        viewModelScope.launch {

            val response = repo.refreshToken(request)

            if (response.isSuccessful) {
                _refreshTokenResponse.postValue(NetworkState.Success(response.body()!!))

            } else {
                _refreshTokenResponse.postValue(NetworkState.Error("Something went Wrong!"))
            }


        }


    }


}