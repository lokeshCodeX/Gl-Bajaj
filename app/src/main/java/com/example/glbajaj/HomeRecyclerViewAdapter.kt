package com.example.glbajaj

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.glbajaj.module.collage

class HomeRecyclerViewAdapter(val context:Context,val itemList:ArrayList<collage>):RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder>() {

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtTopicName: TextView = view.findViewById(R.id.txtRecyclerHomeRowItem)
        var imgTopicImage:ImageView=view.findViewById(R.id.imgHomeRecyclerViewSingleRow)

        var topicId:Int=view.id
        var llContext:LinearLayout=view.findViewById(R.id.llContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        //this help to create initial 10 item/view of recyclerview




    val view=LayoutInflater.from(parent.context).inflate(R.layout.home_recyler_single_row,parent,false)
        return HomeViewHolder(view)

    }


    override fun getItemCount(): Int {
        //it store the total item of list


        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        //it responsible for item recycling and re use ability

        val collage = itemList[position]
        holder.topicId = collage.topicId
        holder.txtTopicName.text = collage.topicName
        holder.imgTopicImage.setImageResource(collage.topicImage)






        when (itemList.size) {
            1 ->
                holder.txtTopicName.setOnClickListener() {
                    val intent = Intent(context, NextTheInstitution::class.java)
                    context.startActivity(intent)
                }

            2 -> holder.txtTopicName.setOnClickListener() {

                val intent = Intent(context, Next2Activity::class.java)
                context.startActivity(intent)

            }


        }
        holder.txtTopicName.setOnClickListener() {
            val intent = Intent(context, NextTheInstitution::class.java)
            context.startActivity(intent)


        }
    }

}