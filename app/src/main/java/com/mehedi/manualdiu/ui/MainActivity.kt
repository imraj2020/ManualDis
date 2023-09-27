package com.mehedi.manualdiu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.mehedi.manualdiu.MyApp
import com.mehedi.manualdiu.R
import com.mehedi.manualdiu.core.NetworkState
import com.mehedi.manualdiu.data.models.RequestLogin
import com.mehedi.manualdiu.databinding.ActivityMainBinding
import com.mehedi.manualdiu.di.ObjModule
import com.mehedi.manualdiu.repos.UserRepo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        viewModel.loginResponse.observe(this) {

            when (it) {
                is NetworkState.Error -> {
                    binding.progressHorizontal.visibility = View.GONE
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_LONG).show()
                }

                is NetworkState.Loading -> {
                    binding.progressHorizontal.visibility = View.VISIBLE

                }

                is NetworkState.Success -> {

                    Toast.makeText(this, "Login Success ! ", Toast.LENGTH_LONG).show()
                    Log.d("TAG", "Data :${it.data} ")

                    binding.progressHorizontal.visibility = View.GONE

                }
            }


        }



        binding.loginBtn.setOnClickListener {

            binding.progressHorizontal.visibility = View.VISIBLE

            val loginRequest = RequestLogin("john@mail.com", "changeme")

            val email = binding.userEmail.text.toString().trim()
            val password = binding.userPasword.text.toString().trim()

            viewModel.loginUser(loginRequest)


        }


    }


}


//interface Factory<T> {
//    fun create(): T
//}
//
//class MainViewModelFactory(private val repo: UserRepo) : Factory<MainViewModel> {
//    override fun create(): MainViewModel {
//        return MainViewModel(repo)
//
//    }
//}
