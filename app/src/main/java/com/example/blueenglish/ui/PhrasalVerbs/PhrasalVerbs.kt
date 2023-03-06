package com.example.blueenglish.ui.PhrasalVerbs

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blueenglish.R
import com.example.blueenglish.data.DataPhrasal
import com.example.blueenglish.modeldata.modelPhrasal.PharsalDataItem
import com.example.blueenglish.modeldata.modeldataVi.IrregularVerbsDataItem
import com.example.blueenglish.ui.PhrasalVerbs.adapter.AdapterPhrasal
import com.example.blueenglish.viewmodel.MyViewmodelPhrasal
import com.example.blueenglish.viewmodel.MyviewmodelVI
import kotlinx.android.synthetic.main.activity_iregular_verbs.*
import kotlinx.android.synthetic.main.activity_phrasal_verbs.*

class PhrasalVerbs : AppCompatActivity() {


    lateinit var myAdapter: AdapterPhrasal
    lateinit var linearLayoutmanager: LinearLayoutManager
    private lateinit var viewModel: MyViewmodelPhrasal

    private lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrasal_verbs)




        linearLayoutmanager = LinearLayoutManager(this)
        recyclerpharsal.layoutManager = linearLayoutmanager

        //crear instancia de view model
        viewModel = ViewModelProviders.of(this).get(MyViewmodelPhrasal::class.java)

        //observer para obtener datos y pasarlos al recycler
        val verbs = Observer<List<PharsalDataItem>>{
            myAdapter = AdapterPhrasal(it)
            myAdapter.notifyDataSetChanged()
            recyclerpharsal.adapter = myAdapter
        }

        viewModel.getListaVerbsLiveData().observe(this,verbs)


        //Crear un mediaplayer
        //Para poner la musica clasica de fondo
        mediaPlayer = MediaPlayer.create(this, R.raw.classic)

        mediaPlayer.start()

    }

    //Manejamos los diferentes estados de la app
    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }


}