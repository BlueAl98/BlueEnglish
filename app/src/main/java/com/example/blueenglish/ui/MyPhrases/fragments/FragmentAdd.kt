package com.example.blueenglish.ui.MyPhrases.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.blueenglish.R
import com.example.blueenglish.modeldata.MyPhrasesModel.PhraseRoom
import com.example.blueenglish.viewmodel.MyViewModelRoom
import kotlinx.android.synthetic.main.dialog_add.*
import kotlinx.android.synthetic.main.dialog_add.view.*

class FragmentAdd : Fragment() {


    private lateinit var mPhraseViewModel : MyViewModelRoom
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view  =   inflater.inflate(R.layout.fragment_add, container, false)


        mPhraseViewModel = ViewModelProvider(this).get(MyViewModelRoom::class.java)



        view.btn_add.setOnClickListener {
            insertDataTodatabase()
        }



        return view
    }


    private fun insertDataTodatabase() {
        val title = et_phrase.text.toString()
        val definition =  et_definition.text.toString()


        if(inputcheck(title,definition)){
            val phrase = PhraseRoom(0,title, definition)

            mPhraseViewModel.addPhrase(phrase)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_fragmentAdd_to_listPhrases, null,
                NavOptions.Builder().setPopUpTo(R.id.listPhrases, true).build())
        }else{
            Toast.makeText(requireContext(), "Error added", Toast.LENGTH_SHORT).show()

        }

    }

    private fun inputcheck(title:String, definition:String):Boolean{
        return !(TextUtils.isEmpty(title) &&
                TextUtils.isEmpty(definition) )

    }


}