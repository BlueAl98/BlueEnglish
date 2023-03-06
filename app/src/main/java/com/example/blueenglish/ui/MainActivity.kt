package com.example.blueenglish.ui

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blueenglish.R
import com.example.blueenglish.data.objTopics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




      //Pasamos la lista de topics al adaptador
      myRecycler.adapter = MyAdapter(objTopics.setTopics())
       myRecycler.layoutManager = LinearLayoutManager(this)




        }






    }





