package com.example.ap7mt

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    val viewModel:SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView1=findViewById<TextView>(R.id.textView1)
        val imageView1=findViewById<ImageView>(R.id.imageView1)
        val cardView=findViewById<CardView>(R.id.cardview)
        cardView.setOnClickListener(){
            val i=Intent(this,SecondActivity::class.java)
            startActivity(i)
        }

        viewModel.refreshCharacter(1)
        viewModel.characterByIdLiveData.observe(this){response->
            if (response==null){
                return@observe
            }
            val name=response.name
            Picasso.get().load(response.image).into(imageView1)
            textView1.text=name
        }
    }
}