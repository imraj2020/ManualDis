package com.mehedi.manualdiu.ui.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.manualdiu.core.NetworkState
import com.mehedi.manualdiu.data.models.register.RequestRegister
import com.mehedi.manualdiu.data.models.register.ResponseRegister
import com.mehedi.manualdiu.repos.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repo: UserRepo) : ViewModel() {

    private var _response = MutableLiveData<NetworkState<ResponseRegister>>()
    val userCreateResponse: LiveData<NetworkState<ResponseRegister>> = _response


//    fun register(request: RequestRegister) {
//        _response.postValue(NetworkState.Loading())
//
//        viewModelScope.launch {
//
//            val response = repo.register(request)
//
//            if (response.isSuccessful) {
//                _response.postValue(NetworkState.Success(response.body()!!))
//
//            } else {
//                _response.postValue(NetworkState.Error("Something went Wrong!"))
//            }
//
//            Log.d("TAG", "loginUser: $response ")
//
//
//        }
//
//
//    }


}