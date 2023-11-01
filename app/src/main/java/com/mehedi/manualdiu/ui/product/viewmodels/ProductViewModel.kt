package com.mehedi.manualdiu.ui.product.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.manualdiu.core.DataState
import com.mehedi.manualdiu.ui.product.repository.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repo: ProductRepo) : ViewModel() {

    private var _productByCategoryResponse = MutableLiveData<DataState<Response<ResponseBody>>>()
    val productByCategoryResponse: LiveData<DataState<Response<ResponseBody>>> =
        _productByCategoryResponse


    fun getCategoryResponse(id: Int) {
        _productByCategoryResponse.postValue(DataState.Loading)

        viewModelScope.launch {

            val response = repo.getProductByCategory(id)

            _productByCategoryResponse.postValue(response)


        }


    }


}