package com.example.blueenglish.ui.MyPhrases.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blueenglish.R
import com.example.blueenglish.ui.MyPhrases.adapter.AdapterPhrases
import com.example.blueenglish.viewmodel.MyViewModelRoom
import kotlinx.android.synthetic.main.fragment_list_phrases.view.*

class ListPhrases : Fragment() {

    private lateinit var mPhraseViewModel : MyViewModelRoom


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_list_phrases, container, false)


        val adapter = AdapterPhrases()
        val recyclerview = view.recycleraddPhrasal
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())


       mPhraseViewModel = ViewModelProvider(this).get(MyViewModelRoom::class.java)
        mPhraseViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)

        })



        view.btn_float.setOnClickListener {
            findNavController().navigate(R.id.action_listPhrases_to_fragmentAdd)
        }



        return view
    }


}