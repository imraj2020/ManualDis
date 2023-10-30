package com.mehedi.manualdiu.ui.home.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.mehedi.manualdiu.base.BaseFragment
import com.mehedi.manualdiu.core.DataState
import com.mehedi.manualdiu.databinding.FragmentHomeBinding
import com.mehedi.manualdiu.ui.home.adapters.CategoryAdapter
import com.mehedi.manualdiu.ui.home.model.ResponseCategoryItem
import com.mehedi.manualdiu.ui.home.viewmodels.HomeViewModel
import com.mehedi.manualdiu.utils.NetworkUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {


    lateinit var adapter: CategoryAdapter

    private val viewModel: HomeViewModel by viewModels()

    override fun responseObserver() {
        viewModel.categoryResponse.observe(viewLifecycleOwner) {

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

                            val mcArray: Array<ResponseCategoryItem> = Gson().fromJson(
                                body,Array<ResponseCategoryItem>::class.java
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

    private fun setData(list: List<ResponseCategoryItem>) {

        list.forEach {
            Log.e("TAG_list", "${it.toString()}")

        }


        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.ctgRCV.apply {
            layoutManager = manager
            adapter = CategoryAdapter(list)


        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCategoryResponse()


    }


}