package com.example.shayripanel

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayripanel.Adapter.categoryAd
import com.example.shayripanel.databinding.ActivityMainBinding
import com.example.shayripanel.model.categorymodel
import com.google.firebase.firestore.BuildConfig
import com.google.firebase.firestore.BuildConfig.*
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        db= FirebaseFirestore.getInstance()

        db.collection("shayri").addSnapshotListener { value, error ->

        val list  = ArrayList<categorymodel>()
        val  data = value?.toObjects(categorymodel::class.java)
        list.addAll(data!!)

        binding.recyclerviewcategory.layoutManager = LinearLayoutManager(this)
        binding.recyclerviewcategory.adapter=categoryAd(this,list)

    }
//        val list = arrayListOf<String>("Motivational shyari","Sad shyari" ,"Emotional shayri","Dosti shayri","love shayri","family shayri" ,"Breakeup shayri","family shayri")




           binding.btnmenu.setOnClickListener {
            if (binding.drawerlayout.isDrawerOpen(Gravity.LEFT)) {
                binding.drawerlayout.closeDrawer(Gravity.LEFT)

            } else {
                binding.drawerlayout.openDrawer(Gravity.LEFT)

            }


        }
//        binding.recyclerviewcategory.layoutManager = LinearLayoutManager(this)
//binding.recyclerviewcategory.adapter=categoryAd(this,list)
        fun onBackPressed() {
            if (binding.drawerlayout.isDrawerOpen(Gravity.LEFT)) {
                binding.drawerlayout.closeDrawer(Gravity.LEFT)
            } else {

                binding.drawerlayout.closeDrawer(Gravity.LEFT)



            }
        }

        binding.navigationview.setNavigationItemSelectedListener {
when(it.itemId){
    R.id.share->{
//





        try {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
            var shareMessage = "\nLet me recommend you this application\n\n"
            shareMessage =
                """
                           ${shareMessage + "https://play.google.com/store/apps/details?id=" + VERSION_NAME}
                           
                           
                           """.trimIndent()
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "choose one"))
        } catch (e: Exception) {
            //e.toString();
        }

//        try {
//            val shareIntent = Intent(Intent.ACTION_SEND)
//            shareIntent.type = "text/plain"
//            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
//            var shareMessage = "\nLet me recommend you this application\n\n"
//            shareMessage =
//                """o
//
//        ${shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID}
//
//
//
//        """.trimIndent()
//            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
//            startActivity(Intent.createChooser(shareIntent, "choose one"))
//        } catch (e: Exception) {
//            //e.toString();
//        }


        true

    }
    R.id.rate->{
        val uri = Uri.parse("market://details?id=$packageName")
        val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(myAppLinkToMarket)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show()
        }
        true
    }
    R.id.more->{

        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
        }

        true
    }
    else->false




}
        }

    }
}