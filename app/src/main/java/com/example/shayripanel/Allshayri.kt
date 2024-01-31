package com.example.shayripanel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayripanel.Adapter.allshayriad
import com.example.shayripanel.databinding.ActivityAllshayriBinding
import com.example.shayripanel.model.shayrimodel
import com.google.firebase.firestore.FirebaseFirestore

class Allshayri : AppCompatActivity() {
    lateinit var binding: ActivityAllshayriBinding
    lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllshayriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()



        val name = intent.getStringExtra("name")

        val id = intent.getStringExtra("id")


        binding.btnback.setOnClickListener {
            onBackPressed()
        }



       binding.catname.text = name.toString()

       db.collection("shayri").document(id!!).collection("all").addSnapshotListener { value, error ->

       val shayrilist = arrayListOf<shayrimodel>()

       val data = value?.toObjects(shayrimodel::class.java)

       shayrilist.addAll(data!!)


      binding.recyclerall.layoutManager = LinearLayoutManager(this)

      binding.recyclerall.adapter = allshayriad(this,shayrilist)


}
//
//        binding.recyclerall.layoutManager = LinearLayoutManager(this)
//binding.recyclerall.adapter




    }
}