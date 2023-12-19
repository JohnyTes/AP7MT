package com.example.ap7mt

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    val viewModel:SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView=findViewById<TextView>(R.id.textView)
        viewModel.refreshCharacter(50)
        viewModel.characterByIdLiveData.observe(this){response->
            if (response==null){
                return@observe
            }
            val name=response.name
            textView.text=name
        }
    }
}