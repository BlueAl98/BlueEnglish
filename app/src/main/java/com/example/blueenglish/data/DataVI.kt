package com.example.blueenglish.data

import android.content.Context
import com.example.blueenglish.modeldata.modeldataVi.IrregularVerbsData
import com.example.blueenglish.modeldata.modeldataVi.IrregularVerbsDataItem
import com.google.gson.Gson
import java.io.IOException

class DataVI {

    //cargamos datos del json
    fun loadData(inFile: String, context: Context):String{
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

    //Obtenemos un verb


    fun random(verb: MutableList<IrregularVerbsDataItem>): IrregularVerbsDataItem {
        val position = (1..verb.size).random()
        return verb[position]
    }


    //Steamos datos y retornamos mutable list
    fun salida(context: Context): IrregularVerbsDataItem {

        val gson = Gson()
        val json = loadData("irregularverbs.json",context)
        val irregular = gson.fromJson(json, IrregularVerbsData::class.java).toMutableList()
        val randomverb = random(irregular)
        return randomverb


    }



    }



