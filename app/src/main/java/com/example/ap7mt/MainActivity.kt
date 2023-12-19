package com.example.ap7mt

import android.os.Bundle
import android.widget.TextView
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
        val textView=findViewById<TextView>(R.id.textView)
        val moshi= Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        val rickAndMortyService: RickAndMortyService=retrofit.create(RickAndMortyService::class.java)
        rickAndMortyService.getCharacterById(50).enqueue(object :Callback<getCharacterByIdResponse>{
            override fun onFailure(call: Call<getCharacterByIdResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<getCharacterByIdResponse>, response: Response<getCharacterByIdResponse>) {
                if(!response.isSuccessful){
                    return
                }
                val body=response.body()!!
                val name=body.name
                textView.text=name
            }
        })
    }
}