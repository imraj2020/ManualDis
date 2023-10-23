package com.mehedi.manualdiu.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.manualdiu.core.DataState
import com.mehedi.manualdiu.repos.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repo: UserRepo) : ViewModel() {

    private var _response = MutableLiveData<DataState<Response<ResponseBody>>>()
    val userProfileResponse: LiveData<DataState<Response<ResponseBody>>> = _response


    fun profile() {
        _response.postValue(DataState.Loading)

        viewModelScope.launch {
            val response = repo.profile()
            _response.postValue(response)


        }


    }


}