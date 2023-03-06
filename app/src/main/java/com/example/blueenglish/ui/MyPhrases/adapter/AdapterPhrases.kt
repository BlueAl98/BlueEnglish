package com.example.blueenglish.ui.MyPhrases.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.blueenglish.R
import com.example.blueenglish.modeldata.MyPhrasesModel.PhraseRoom
import com.example.blueenglish.ui.MyPhrases.fragments.ListPhrasesDirections
import kotlinx.android.synthetic.main.item_add_phrase.view.*

class AdapterPhrases():
    RecyclerView.Adapter<AdapterPhrases.ViewHolder>(){

    private var phraseList = emptyList<PhraseRoom>()


   class ViewHolder(Itemview : View):RecyclerView.ViewHolder(Itemview) {

       val title = Itemview.tvtitleadd
       val definition = Itemview.tvdefinitionadd



    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context,)
            .inflate(R.layout.item_add_phrase, parent, false)
            return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val currentphrase = phraseList[position]

        holder.title.text = currentphrase.title
        holder.definition.text = currentphrase.definition

       holder.itemView.setOnClickListener {
         val action = ListPhrasesDirections.actionListPhrasesToUpdatePhrases(currentphrase)
         holder.itemView.findNavController().navigate(action)
       }




    }

    override fun getItemCount(): Int {
      return  phraseList.size
    }

fun setData(phrase: List<PhraseRoom>){
    this.phraseList = phrase
    notifyDataSetChanged()
}


}
