package com.example.blueenglish.ui.MyPhrases.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.blueenglish.R
import com.example.blueenglish.modeldata.MyPhrasesModel.PhraseRoom
import com.example.blueenglish.viewmodel.MyViewModelRoom
import kotlinx.android.synthetic.main.fragment_update_phrases.*
import kotlinx.android.synthetic.main.fragment_update_phrases.view.*


class UpdatePhrases : Fragment() {


    private val args by navArgs<UpdatePhrasesArgs>()

    private lateinit var mPhraseViewModelRoom: MyViewModelRoom


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view  =  inflater.inflate(R.layout.fragment_update_phrases, container, false)


        mPhraseViewModelRoom = ViewModelProvider(this).get(
            MyViewModelRoom::class.java
        )

        view.et_phraseUP.setText(args.currentPhrase.title)
        view.et_definitionUP.setText(args.currentPhrase.definition)


    view.btn_UP.setOnClickListener {
        updateItem()
        //activity?.supportFragmentManager?.popBackStack()
    }

    view.btn_delete.setOnClickListener {
        deleteItem()
    }







        return view
    }

    private fun updateItem() {

    val title = et_phraseUP.text.toString()
    val definition = et_definitionUP.text.toString()

    if(inputcheck(title, definition)){

        val updatephrase = PhraseRoom(args.currentPhrase.id,
        title, definition)

        mPhraseViewModelRoom.updatePhrase(updatephrase)

        findNavController().navigate(R.id.action_updatePhrases_to_listPhrases, null,
            NavOptions.Builder().setPopUpTo(R.id.listPhrases, true).build())
        //activity?.onBackPressed()


        Toast.makeText(requireContext(), "Update Successfully", Toast.LENGTH_SHORT).show()


    }else{
        Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()

    }


    }

    private fun inputcheck(title:String, definition:String):Boolean{
        return !(TextUtils.isEmpty(title) &&
                TextUtils.isEmpty(definition) )

    }


    private fun deleteItem() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _,_ ->
            mPhraseViewModelRoom.deletePhrase(args.currentPhrase)
            Toast.makeText(requireContext(), "Successfully removed", Toast.LENGTH_SHORT).show()


            findNavController().navigate(R.id.action_updatePhrases_to_listPhrases, null,
                NavOptions.Builder().setPopUpTo(R.id.listPhrases, true).build())


        }
        builder.setNegativeButton("No"){ _,_ ->

            Toast.makeText(requireContext(), "Error removed item", Toast.LENGTH_SHORT).show()



        }

        builder.setTitle("Delete ${args.currentPhrase.title}?")
        builder.setMessage("Are you sure you want to delete ${args.currentPhrase.title}? ")
        builder.create().show()

    }


}