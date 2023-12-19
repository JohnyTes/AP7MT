package com.example.ap7mt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val moshi= Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        val rickAndMortyService: RickAndMortyService=retrofit.create(RickAndMortyService::class.java)
        rickAndMortyService.getCharacterById().enqueue(object :Callback<Any>{
            override fun onFailure(call: Call<Any>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                TODO("Not yet implemented")
            }
        })
    }
}