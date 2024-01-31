package com.example.shayripanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class spalshactivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalshactivty)


        Handler().postDelayed(Runnable {
            startActivity(Intent(this,startactivity::class.java))
            finish()
        },3000)
    }
}