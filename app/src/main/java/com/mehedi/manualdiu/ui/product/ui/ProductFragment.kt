package com.mehedi.manualdiu.ui.product.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.google.gson.Gson
import com.mehedi.manualdiu.base.BaseFragment
import com.mehedi.manualdiu.core.DataState
import com.mehedi.manualdiu.databinding.FragmentProductBinding
import com.mehedi.manualdiu.ui.product.models.ResponseProductItem
import com.mehedi.manualdiu.ui.product.viewmodels.ProductViewModel
import com.mehedi.manualdiu.utils.NetworkUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding>(FragmentProductBinding::inflate) {

    val viewmodel: ProductViewModel by viewModels()

    override fun responseObserver() {
        viewmodel.productByCategoryResponse.observe(viewLifecycleOwner) {
            when (it) {

                is DataState.Success -> {

                    // get data
                    val body = it.value.body()?.string()

                    if (body.isNullOrBlank()) {

                        var eerr = it.value.errorBody()?.string()
                        Log.e("TAG", eerr.toString())
                    } else {
                        Log.e("TAG", body.toString())
                        if (NetworkUtils.isValidResponse(it)) {

                            val mcArray: Array<ResponseProductItem> = Gson().fromJson(
                                body, Array<ResponseProductItem>::class.java
                            )
                            mcArray.forEach {
                                Log.e("TAG", "${it.toString()}")

                            }

                            setData(mcArray.toList())


                        } else {
                            //howToast(getString(R.string.something_went_wrong))
                        }
                    }
                }

                is DataState.Loading -> {


                    Log.d("TAG", "Loading....: ")
                }

                is DataState.Error -> {


                    if (it.isNetworkError) {
                        //showToast(getString(R.string.internet_conn_lost_title))
                    } else {
                        //reLogin()
                    }
                    Log.e("TAG", "$it")
                }
            }


        }

    }

    private fun setData(productList: List<ResponseProductItem>) {

        productList.forEach {
            Log.e("TAG", "product: $it \n")

        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("ctg")?.let {
            viewmodel.getCategoryResponse(it)
        }


    }


}