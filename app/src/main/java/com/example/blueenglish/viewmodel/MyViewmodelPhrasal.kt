package com.example.blueenglish.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.blueenglish.domain.UseCasePhrasal
import com.example.blueenglish.modeldata.modelPhrasal.PharsalDataItem

class MyViewmodelPhrasal (application: Application): AndroidViewModel(application) {

    val listverbs = MutableLiveData<List<PharsalDataItem>>()
    val phrasalUsecase = UseCasePhrasal()


    init {
        getListaVerbs(application)
    }

    //seteara la lista con la obtencion de datos y la pasara a listverbs
    fun setListData(listaPhrasal:List<PharsalDataItem>){
        listverbs.value = listaPhrasal
    }

    //buscara en el repositorio
    fun getListaVerbs(context: Context){
        setListData(phrasalUsecase.obtenerlistaphrasal(context))
    }
    fun getListaVerbsLiveData():LiveData<List<PharsalDataItem>>{
        return listverbs
    }


}