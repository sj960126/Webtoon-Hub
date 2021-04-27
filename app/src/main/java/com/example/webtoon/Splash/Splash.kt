package com.example.webtoon.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.example.webtoon.MainActivity
import com.example.webtoon.Model.WebToonModel
import com.example.webtoon.databinding.ActivitySplashBinding
import com.example.webtoon.retorfit.RetrofitManager
import com.example.webtoon.utils.Constants
import com.example.webtoon.utils.RESPONSE_STATE


class Splash : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    lateinit var webtoonList :  ArrayList<WebToonModel>
    val SPLASH_TIME: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },SPLASH_TIME)
    }
}