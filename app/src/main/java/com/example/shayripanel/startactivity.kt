package com.example.shayripanel

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shayripanel.databinding.ActivityStartactivityBinding


class startactivity : AppCompatActivity() {
    lateinit var binding: ActivityStartactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)




            binding.btnstart.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))


            }
            binding.btnrate.setOnClickListener {




            val uri = Uri.parse("market://details?id=$packageName")
            val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
            try {
                startActivity(myAppLinkToMarket)
            } catch (e: ActivityNotFoundException) {

                Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show()
            }
        }
            binding.btnmore.setOnClickListener {

            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
            }

        }
    }
}