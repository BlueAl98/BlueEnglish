package com.example.blueenglish.data

import com.example.blueenglish.modeldata.dataTopics.TopicsData

object objTopics {



    //Lista de temas principal pantalla return

    fun setTopics():List<TopicsData>{
        var Topiclist = mutableListOf<TopicsData>()

        Topiclist.add(
            TopicsData(
                "Most Used Words"
            )
        )


            Topiclist.add(
                TopicsData(
                    "Phrasal Verbs"
                    )

        )


        Topiclist.add(
            TopicsData(
                "Add your Phrases"
            )

        )

        Topiclist.add(
            TopicsData(
                "Irregular verbs"
            )

        )



        return Topiclist

    }

}