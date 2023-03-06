package com.example.blueenglish.modeldata.MyPhrasesModel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "phrases")
data class PhraseRoom(
    @PrimaryKey (autoGenerate = true)
    var id: Int,
    var title : String,
    var definition : String
    ): Parcelable
