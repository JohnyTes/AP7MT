package com.example.ap7mt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso

class SecondActivity : AppCompatActivity() {
    val viewModel:SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val passedData = intent.getIntExtra("passedData",1)
        val textview_name=findViewById<TextView>(R.id.textViewName)
        val textview_origin=findViewById<TextView>(R.id.textViewOrigin)
        val textview_species=findViewById<TextView>(R.id.textViewSpecies)
        val textview_status=findViewById<TextView>(R.id.textViewStatus)
        val imageView1=findViewById<ImageView>(R.id.imageView)
        viewModel.refreshCharacter(passedData)
        viewModel.characterByIdLiveData.observe(this){response->
            if (response==null){
                return@observe
            }
            val name=response.name
            Picasso.get().load(response.image).into(imageView1)
            textview_name.text=name
            textview_origin.text=response.origin.name
            textview_species.text=response.species
            textview_status.text=response.status
        }
    }
}