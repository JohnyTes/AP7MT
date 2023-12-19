package com.example.ap7mt

import android.content.Context
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

        val sharedPref=getSharedPreferences("$passedData", Context.MODE_PRIVATE)
        val editor=sharedPref.edit()

        val textview_name=findViewById<TextView>(R.id.textViewName)
        val textview_origin=findViewById<TextView>(R.id.textViewOrigin)
        val textview_species=findViewById<TextView>(R.id.textViewSpecies)
        val textview_status=findViewById<TextView>(R.id.textViewStatus)
        val imageView1=findViewById<ImageView>(R.id.imageView)

        val name=sharedPref.getString("name",null)

        if (name!=null){
            val status=sharedPref.getString("status",null)
            val origin=sharedPref.getString("origin",null)
            val species=sharedPref.getString("species",null)
            textview_name.text=name
            textview_origin.text=origin
            textview_species.text=species
            textview_status.text=status
        }else{

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
                editor.apply{
                    putString("name",response.name)
                    putString("origin",response.origin.name)
                    putString("species",response.species)
                    putString("status",response.status)
                    apply()
                }
            }
        }
    }
}