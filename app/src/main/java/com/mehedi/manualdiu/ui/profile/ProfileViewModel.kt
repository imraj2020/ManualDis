package com.mehedi.manualdiu.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.manualdiu.core.NetworkState
import com.mehedi.manualdiu.data.models.register.ResponseRegister
import com.mehedi.manualdiu.repos.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repo: UserRepo) : ViewModel() {

    private var _response = MutableLiveData<NetworkState<ResponseRegister>>()
    val userProfileResponse: LiveData<NetworkState<ResponseRegister>> = _response


     fun profile() {
        _response.postValue(NetworkState.Loading())

        viewModelScope.launch {

            val response = repo.profile()

            if (response.isSuccessful) {
                _response.postValue(NetworkState.Success(response.body()!!))

            } else {
                _response.postValue(NetworkState.Error("Something went Wrong!"))
            }

            Log.d("TAG", "loginUser: $response ")


        }


    }


}