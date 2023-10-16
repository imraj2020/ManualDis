package com.mehedi.manualdiu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mehedi.manualdiu.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {




    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





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
