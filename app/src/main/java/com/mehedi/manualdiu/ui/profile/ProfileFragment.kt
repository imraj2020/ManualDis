package com.mehedi.manualdiu.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mehedi.manualdiu.base.BaseFragment
import com.mehedi.manualdiu.core.NetworkState
import com.mehedi.manualdiu.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    val viewModel :ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.profile()
    }

    override fun responseObserver() {


        viewModel.userProfileResponse.observe(viewLifecycleOwner){

            when (it) {
                is NetworkState.Error -> {
                    binding.progressHorizontal.visibility = View.GONE
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_LONG).show()
                }

                is NetworkState.Loading -> {
                    binding.progressHorizontal.visibility = View.VISIBLE

                }

                is NetworkState.Success -> {

                    Toast.makeText(requireContext(), "User Created!", Toast.LENGTH_LONG).show()
                    Log.d("TAG", "Data :${it.data} ")

                    binding.progressHorizontal.visibility = View.GONE


                }
            }


        }




    }


}