package com.example.blueenglish.ui.PhrasalVerbs.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.blueenglish.R
import com.example.blueenglish.modeldata.modelPhrasal.PharsalDataItem
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.item_phrasal.view.*

class AdapterPhrasal (val phrasal: List<PharsalDataItem>) :
RecyclerView.Adapter<AdapterPhrasal.ViewHolder>()
{
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val vphrasal: TextView = itemView.tvphrasal


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_phrasal, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.vphrasal.text = phrasal[position].PV


         holder.itemView.setOnClickListener{
             val dialog = BottomSheetDialog(holder.itemView.context)
             val view  = LayoutInflater.from(holder.itemView.context).inflate(R.layout.item_detail, null)
             dialog.setCancelable(true)

             val tvVerb = view.findViewById<TextView>(R.id.tvverb)
             val tvdefinition = view.findViewById<TextView>(R.id.tvdefinition)
             val tvexample = view.findViewById<TextView>(R.id.tvexample)
             val tvexamplet = view.findViewById<TextView>(R.id.tvexampleT)

             tvVerb.text = phrasal[position].PV
             tvdefinition.text = phrasal[position].TV
             tvexample.text = phrasal[position].EX
             tvexamplet.text = phrasal[position].EXT

             dialog.setContentView(view)
             dialog.show()

         }



    }

    override fun getItemCount(): Int {
        return phrasal.size
    }


}