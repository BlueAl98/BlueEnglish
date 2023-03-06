package com.example.blueenglish.data

import android.content.Context
import com.example.blueenglish.modeldata.modelPhrasal.PharsalData
import com.example.blueenglish.modeldata.modelPhrasal.PharsalDataItem
import com.google.gson.Gson

import java.io.IOException



class DataPhrasal {

    fun salida(context: Context): List<PharsalDataItem> {

        val gson = Gson()
        val json = loadData("myphrasal.json",context)
        val phrasal = gson.fromJson(json, PharsalData::class.java ).toList()
        return phrasal


    }


    fun loadData(inFile: String, context:Context):String{
        var tvContents = ""

        try {
            val stream = context.assets.open(inFile)

            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            tvContents = String(buffer)
        }catch (e : IOException){

        }
        return tvContents
    }


}