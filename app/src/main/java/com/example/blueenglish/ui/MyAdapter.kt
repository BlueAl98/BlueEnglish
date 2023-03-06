package com.example.blueenglish.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blueenglish.ui.IregularVerbs.IregularVerbs
import com.example.blueenglish.ui.PhrasalVerbs.PhrasalVerbs
import com.example.blueenglish.R
import com.example.blueenglish.modeldata.dataTopics.TopicsData
import com.example.blueenglish.ui.MyPhrases.PhrasesAddActivity
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter(val topics:List<TopicsData>):
    RecyclerView.Adapter<MyAdapter.myViewHolder>() {



    class myViewHolder (view:View): RecyclerView.ViewHolder(view) {


        var title =  view.title



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       var itemView = LayoutInflater.from(
           parent.context).inflate(
           R.layout.item_view,parent, false
           )

        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.title.text = topics[position].title

        holder.itemView.setOnClickListener {

            when(position){
                1->{


                    val intente = Intent(holder.itemView.context, PhrasalVerbs::class.java)
                    holder.itemView.context.startActivity(intente)



                }

                2->{


                    val intente = Intent(holder.itemView.context, PhrasesAddActivity::class.java)
                    holder.itemView.context.startActivity(intente)



                }

                3->{
                    val intente = Intent(holder.itemView.context, IregularVerbs::class.java)
                    holder.itemView.context.startActivity(intente)
                }
            }



        }


    }

    override fun getItemCount(): Int {
        return topics.size
    }

}


