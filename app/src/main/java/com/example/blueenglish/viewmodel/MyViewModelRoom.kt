package com.example.blueenglish.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.blueenglish.data.PhraseDataBase
import com.example.blueenglish.domain.UseCaseRoom
import com.example.blueenglish.modeldata.MyPhrasesModel.PhraseRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModelRoom(application: Application):
    AndroidViewModel(application) {

   val readAllData : LiveData<List<PhraseRoom>>
   private val useCase : UseCaseRoom


   init {
       val phraseDao = PhraseDataBase.getDataBase(application).phaseDao()
       useCase =  UseCaseRoom(phraseDao)
       readAllData = useCase.readAllData

   }


  fun addPhrase(phrase: PhraseRoom){
      viewModelScope.launch(Dispatchers.IO) {

          useCase.addPhrase(phrase)

      }
  }

    fun updatePhrase(phrase: PhraseRoom){
        viewModelScope.launch(Dispatchers.IO) {

            useCase.updatePhrase(phrase)

        }
    }

    fun deletePhrase(phrase: PhraseRoom){
        viewModelScope.launch(Dispatchers.IO) {

            useCase.deletePhrase(phrase)

        }
    }


}