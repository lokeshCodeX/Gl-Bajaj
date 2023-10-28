package com.example.glbajaj

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.glbajaj.module.collage

class HomeFragment : Fragment() {

    lateinit var recyclerViewHome:RecyclerView
    lateinit var layoutManger:LinearLayoutManager


    var headlineList= arrayListOf(

        "The Institute",
        "Our Insipiration",
        "Vision& Mission",
        "Messages",
        "Adjunct Professor",
        "Board Of Governance",
        "Coporate Advisory Board ",
        "Logo Philosophy",
        "Social Initiative",
        "Why Us",
        "Goverment Recognitions",
        "Institutional Polocies & Governance"





    )


    var headlineListInfo= arrayListOf<collage>(

        collage(1,"The Institute",R.drawable.img_the_instution),
        collage(2,"Our Insipiration",R.drawable.img_insipiration),
        collage(3,"Vision & Mission",R.drawable.img_vision),
        collage(4,"Message",R.drawable.img_message),
        collage(5,"Adjunct Professor",R.drawable.img_professor),
        collage(6,"Board Of Governance",R.drawable.img_board_of_governance),
        collage(7,"Coparate Advisory Board",R.drawable.img_advisior_board),
        collage(8,"Logo Philosophy",R.drawable.img_philospy),
        collage(9,"Social Initiative",R.drawable.img_social_initiative),
        collage(10,"why Us",R.drawable.img_why_us),
        collage(11,"Government Recognitions",R.drawable.img_government_recognitions),
        collage(12,"Institutional Polocies & Governance",R.drawable.img_institutional_polocies),






    )

       lateinit var recyclerAdapter:HomeRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.fragment_home, container, false)


        recyclerViewHome=view.findViewById(R.id.recyclerViewHomeFrag)

        layoutManger= LinearLayoutManager(activity)

        recyclerAdapter= HomeRecyclerViewAdapter(activity as Context,headlineListInfo)

        recyclerViewHome.adapter=recyclerAdapter
        recyclerViewHome.layoutManager=layoutManger

        recyclerViewHome.addItemDecoration(
            DividerItemDecoration(
                recyclerViewHome.context,
                (layoutManger as LinearLayoutManager).orientation
            )
        )



        return view
    }

}