package com.example.blueenglish.domain

import androidx.lifecycle.LiveData
import com.example.blueenglish.data.DaoPhrase
import com.example.blueenglish.modeldata.MyPhrasesModel.PhraseRoom

class UseCaseRoom (private val phraseDao: DaoPhrase){


    val readAllData: LiveData<List<PhraseRoom>> = phraseDao.readData()


    suspend fun addPhrase(phrase: PhraseRoom){
        phraseDao.addPhrase(phrase)

    }

    suspend fun updatePhrase(phrase: PhraseRoom){
        phraseDao.updatephrase(phrase)

    }

    suspend fun deletePhrase(phrase: PhraseRoom){
        phraseDao.deletePhrase(phrase)
    }






}