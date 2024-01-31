package com.example.shayripanel.Adapter

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shayripanel.Allshayri
import com.example.shayripanel.MainActivity
import com.example.shayripanel.databinding.ShariformatBinding
import com.example.shayripanel.model.categorymodel
import com.google.firebase.database.collection.LLRBNode

class categoryAd(val mainActivity: MainActivity, val list: ArrayList<categorymodel>) :RecyclerView.Adapter<categoryAd.Viewholder>(){
    class Viewholder (val binding: ShariformatBinding):RecyclerView.ViewHolder(binding.root){


//        val Colorlist = arrayListOf<String>("#3498db","#8e44ad","#e67e22","#27ae)60","#e74c3c")
val ColorList = arrayListOf("#3498db","#8e44ad","#e67e22","#27ae60","#e74c3c")

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(ShariformatBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

        if (position%5 ==0){
           holder.binding.itemtext.setBackgroundColor(Color.CYAN)
        }else if (position%5 ==1){
            holder.binding.itemtext.setBackgroundColor(Color.TRANSPARENT)
        }else if ((position%5 ==2)){
            holder.binding.itemtext.setBackgroundColor(Color.CYAN)
        }else if ((position%5 ==3)){
            holder.binding.itemtext.setBackgroundColor(Color.MAGENTA)
        }else if ((position%5 ==4)){
            holder.binding.itemtext.setBackgroundColor(Color.YELLOW)
        }





               holder.binding.itemtext.text = list[position].name.toString()
               holder.binding.itemtext.setOnClickListener {


               val intent = Intent(mainActivity,Allshayri::class.java)
               intent.putExtra("id",list[position].id)
               intent.putExtra("name",list[position].name)
               mainActivity.startActivity(intent)
        }



                ObjectAnimator.ofFloat(holder.binding.itemtext,View.TRANSLATION_Y,3000f,0f).apply {
                duration = 200
                start()
        }
    }
}