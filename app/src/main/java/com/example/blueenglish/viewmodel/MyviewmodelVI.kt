package com.example.blueenglish.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.blueenglish.data.DataVI
import com.example.blueenglish.modeldata.modeldataVi.IrregularVerbsDataItem


class MyviewmodelVI (application: Application): AndroidViewModel(application){

    val verbLive = MutableLiveData<IrregularVerbsDataItem>()

    //Data
    val verb = DataVI()



  //Random verb irregular
    fun random(context: Context){
        val currentverb = verb.salida(context)
        verbLive.postValue(currentverb)
    }

}