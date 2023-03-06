package com.example.blueenglish.ui.IregularVerbs

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blueenglish.R
import com.example.blueenglish.modeldata.modeldataVi.IrregularVerbsDataItem
import com.example.blueenglish.viewmodel.MyviewmodelVI

import kotlinx.android.synthetic.main.activity_iregular_verbs.*

class IregularVerbs : AppCompatActivity() {


    private val viewModel: MyviewmodelVI by viewModels()
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iregular_verbs)

       /*
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN
        }
*/

        //crear instancia de view model atravez de un observer
        //pasamos la informacion a los textview
        viewModel.verbLive.observe(this, Observer {
            infinitive.text = it.infinitive
            past.text = it.past
            pastP.text = it.participle
            translation.text = it.translation
            example.text = it.example
            exampleESP.text = it.espverb

        })

        //Boton para traer un verbo al alzar
         btnNext.setOnClickListener {
            viewModel.random(this)
        }

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