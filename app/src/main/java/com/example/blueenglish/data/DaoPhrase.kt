package com.example.blueenglish.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.blueenglish.modeldata.MyPhrasesModel.PhraseRoom

@Dao
interface DaoPhrase {

 @Insert(onConflict = OnConflictStrategy.IGNORE)
 suspend fun addPhrase(phrase: PhraseRoom)

 @Query("SELECT * FROM phrases ORDER BY id ASC")
 fun readData(): LiveData<List<PhraseRoom>>

 @Update
 suspend fun updatephrase(phrase: PhraseRoom)

 @Delete
 suspend fun deletePhrase(phraseRoom: PhraseRoom)



}