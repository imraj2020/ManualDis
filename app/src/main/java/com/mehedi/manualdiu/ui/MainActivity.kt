package com.mehedi.manualdiu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import com.mehedi.manualdiu.MyApp
import com.mehedi.manualdiu.R
import com.mehedi.manualdiu.data.models.RequestLogin
import com.mehedi.manualdiu.di.ObjContainer
import com.mehedi.manualdiu.repos.UserRepo

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var container: ObjContainer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = MyApp().container

        viewModel = MainViewModelFactory(container.userRepo).create()

        viewModel.loginResponse.observe(this) {

            if (it.accessToken != null) {
                Log.d("TAG", "data : $it")

            }


        }



        findViewById<Button>(R.id.loginBtn).setOnClickListener {

            val loginRequest = RequestLogin("john@mail.com", "changeme")

            viewModel.loginUser(loginRequest)


        }


    }



}


interface Factory<T> {
    fun create(): T
}

class MainViewModelFactory(private val repo: UserRepo) : Factory<MainViewModel> {
    override fun create(): MainViewModel {
        return MainViewModel(repo)

    }
}
