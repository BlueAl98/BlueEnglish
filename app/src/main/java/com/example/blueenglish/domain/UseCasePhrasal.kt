package com.example.blueenglish.domain

import android.content.Context
import android.provider.ContactsContract.Data
import com.example.blueenglish.data.DataPhrasal
import com.example.blueenglish.modeldata.modelPhrasal.PharsalDataItem

class UseCasePhrasal  {

    val verbsPhrasal = DataPhrasal()

    fun obtenerlistaphrasal(context:Context): List<PharsalDataItem>{
        return verbsPhrasal.salida(context)
    }


}