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
import com.mehedi.manualdiu.data.models.login.RequestLogin
import com.mehedi.manualdiu.data.models.token.RequestToken
import com.mehedi.manualdiu.databinding.FragmentLoginBinding
import com.mehedi.manualdiu.utils.KEY_ACCESS
import com.mehedi.manualdiu.utils.KEY_REFRESH
import com.mehedi.manualdiu.utils.PrefsManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    @Inject
    lateinit var prefsManager: PrefsManager


    private val viewModel: LoginViewModel by viewModels()
    override fun responseObserver() {


        viewModel.refreshTokenResponse.observe(viewLifecycleOwner) {


            when (it) {
                is NetworkState.Error -> {
                    binding.animationView.visibility = View.GONE
                    binding.mainView.visibility = View.VISIBLE

                }

                is NetworkState.Loading -> {
                    binding.animationView.visibility = View.VISIBLE
                    binding.mainView.visibility = View.GONE


                }

                is NetworkState.Success -> {

                    it.data?.accessToken?.let { it1 -> prefsManager.setPref(KEY_ACCESS, it1) }
                    it.data?.refreshToken?.let { it1 -> prefsManager.setPref(KEY_REFRESH, it1) }

                    Log.d("TAG", "New Token :${it.data} ")
                    findNavController().navigate(R.id.action_loginFragment_to_profileFragment)


                }
            }

        }




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
                    it.data?.accessToken?.let { it1 -> prefsManager.setPref(KEY_ACCESS, it1) }
                    it.data?.refreshToken?.let { it1 -> prefsManager.setPref(KEY_REFRESH, it1) }


                    Toast.makeText(requireContext(), "Login Success ! ", Toast.LENGTH_LONG).show()
                    Log.d("TAG", "Old Token :${it.data} ")

                    binding.progressHorizontal.visibility = View.GONE
                    findNavController().navigate(R.id.action_loginFragment_to_profileFragment)


                }
            }


        }



        viewModel.refreshToken(RequestToken(prefsManager.getPref(KEY_REFRESH)))


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.RegisterBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_regsiterFragment)
        }







        binding.loginBtn.setOnClickListener {

            binding.progressHorizontal.visibility = View.VISIBLE

            val loginRequest = RequestLogin("john@mail.com", "changeme")

            val email = binding.userEmail.text.toString().trim()
            val password = binding.userPasword.text.toString().trim()

            // val loginRequest = RequestLogin(email = email, password = password)

            viewModel.loginUser(loginRequest)


        }

    }


}