package com.example.blueenglish.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.blueenglish.modeldata.MyPhrasesModel.PhraseRoom


@Database(entities = [PhraseRoom::class], version = 1,
exportSchema = false)
abstract class PhraseDataBase :RoomDatabase() {

    abstract fun phaseDao():DaoPhrase
    companion object{
        @Volatile
        private var INTANCE : PhraseDataBase? = null

        fun getDataBase(context: Context): PhraseDataBase{
        val temIntance = INTANCE

            if (temIntance != null){
                return temIntance
            }
            synchronized(this){
            val instance = Room.databaseBuilder(
                context.applicationContext,
                PhraseDataBase::class.java,
                "phrases_database"
            ) .build()
            return instance
            }
        }
    }



}