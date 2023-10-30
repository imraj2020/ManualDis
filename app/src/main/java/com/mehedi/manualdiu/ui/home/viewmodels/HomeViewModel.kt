package com.mehedi.manualdiu.ui.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.manualdiu.core.DataState
import com.mehedi.manualdiu.ui.home.repository.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: HomeRepo) : ViewModel() {

    private var _categoryResponse = MutableLiveData<DataState<Response<ResponseBody>>>()
    val categoryResponse: LiveData<DataState<Response<ResponseBody>>> = _categoryResponse


    fun getCategoryResponse() {
        _categoryResponse.postValue(DataState.Loading)

        viewModelScope.launch {

            val response = repo.getCategories()

            _categoryResponse.postValue(response)


        }


    }


}