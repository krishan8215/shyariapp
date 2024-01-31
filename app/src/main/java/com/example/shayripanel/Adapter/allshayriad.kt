package com.example.shayripanel.Adapter

import android.animation.ObjectAnimator
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shayripanel.Allshayri
import com.example.shayripanel.R
import com.example.shayripanel.databinding.FinallayBinding
import com.example.shayripanel.model.shayrimodel


class allshayriad( val allshayri: Allshayri,  val shayrilist: ArrayList<shayrimodel>) :RecyclerView.Adapter<allshayriad.shayriviewholder>(){

    class shayriviewholder(val binding: FinallayBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): shayriviewholder {
        return shayriviewholder(FinallayBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


       override fun getItemCount() = shayrilist.size

       override fun onBindViewHolder(holder: shayriviewholder, position: Int) {

        if (position%5 ==0){
            holder.binding.manbackground.setBackgroundColor(Color.CYAN)
        }else if (position%5 ==1){
            holder.binding.manbackground.setBackgroundResource(R.drawable.gradient2)
        }else if ((position%5 ==2)){
            holder.binding.manbackground.setBackgroundResource(R.drawable.gradient1)
            holder.binding.manbackground.setBackgroundResource(R.drawable.gradient4)
        }else if ((position%5 ==3)){
            holder.binding.manbackground.setBackgroundResource(R.drawable.gradient3)
        }else if ((position%5 ==4)){
        }

                  holder.binding.itemshayri.text = shayrilist[position].data.toString()
                 ObjectAnimator.ofFloat(holder.binding.manbackground,View.TRANSLATION_X, 3000f,0f).apply {
                 duration = 200
                 start()
           }
}}