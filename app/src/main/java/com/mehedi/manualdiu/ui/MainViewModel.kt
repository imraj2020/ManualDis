package com.mehedi.manualdiu.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.manualdiu.data.models.RequestLogin
import com.mehedi.manualdiu.data.models.ResponseLogin
import com.mehedi.manualdiu.repos.UserRepo
import kotlinx.coroutines.launch

class MainViewModel(private val repo: UserRepo) : ViewModel() {

    private var _loginResponse = MutableLiveData<ResponseLogin>()
    val loginResponse: LiveData<ResponseLogin> = _loginResponse


    fun loginUser(requestLogin: RequestLogin) {

        viewModelScope.launch {

            val response = repo.loginUser(requestLogin)

            if (response.isSuccessful) {
                _loginResponse.postValue(response.body())
            }

            Log.d("TAG", "loginUser: $response ")




        }


    }


}