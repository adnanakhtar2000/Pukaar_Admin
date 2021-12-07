package com.example.pukaaradmin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.databinding.ActivitySplashScreenBinding

class Splash_Screen : AppCompatActivity() {

    lateinit var splashScreenBinding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashScreenBinding.root)
        Handler().postDelayed({
            if(CommonFunction.getToken(applicationContext).length>10)
            {
                val intent = Intent(this, Dashboard::class.java);
                startActivity(intent);
                finish();
            }
            else {
                val intent = Intent(this, Login::class.java);
                startActivity(intent);
                finish();
            }
        }, 2000)
    }
}