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
            i.putExtra("passedData",1)
            startActivity(i)
        }
        val cardView2=findViewById<CardView>(R.id.cardview2)
        cardView2.setOnClickListener(){
            val i=Intent(this,SecondActivity::class.java)
            i.putExtra("passedData",2)
            startActivity(i)
        }
        val cardView3=findViewById<CardView>(R.id.cardview3)
        cardView3.setOnClickListener(){
            val i=Intent(this,SecondActivity::class.java)
            i.putExtra("passedData",3)
            startActivity(i)
        }
        val cardView4=findViewById<CardView>(R.id.cardview4)
        cardView4.setOnClickListener(){
            val i=Intent(this,SecondActivity::class.java)
            i.putExtra("passedData",4)
            startActivity(i)
        }
        val cardView5=findViewById<CardView>(R.id.cardview5)
        cardView5.setOnClickListener(){
            val i=Intent(this,SecondActivity::class.java)
            i.putExtra("passedData",5)
            startActivity(i)
        }
    }
}