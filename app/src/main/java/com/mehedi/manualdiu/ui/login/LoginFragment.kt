package com.mehedi.manualdiu.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mehedi.manualdiu.R
import com.mehedi.manualdiu.base.BaseFragment
import com.mehedi.manualdiu.core.NetworkState
import com.mehedi.manualdiu.data.models.RequestLogin
import com.mehedi.manualdiu.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()
    override fun responseObserver() {
        viewModel.loginResponse.observe(viewLifecycleOwner) {

            when (it) {
                is NetworkState.Error -> {
                    binding.progressHorizontal.visibility = View.GONE
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_LONG).show()
                }

                is NetworkState.Loading -> {
                    binding.progressHorizontal.visibility = View.VISIBLE

                }

                is NetworkState.Success -> {

                    Toast.makeText(requireContext(), "Login Success ! ", Toast.LENGTH_LONG).show()
                    Log.d("TAG", "Data :${it.data} ")

                    binding.progressHorizontal.visibility = View.GONE

                }
            }


        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.RegisterBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_regsiterFragment)
        }







        binding.loginBtn.setOnClickListener {

            binding.progressHorizontal.visibility = View.VISIBLE

            // val loginRequest = RequestLogin("john@mail.com", "changeme")

            val email = binding.userEmail.text.toString().trim()
            val password = binding.userPasword.text.toString().trim()

            val loginRequest = RequestLogin(email = email, password = password)

            viewModel.loginUser(loginRequest)


        }

    }


}