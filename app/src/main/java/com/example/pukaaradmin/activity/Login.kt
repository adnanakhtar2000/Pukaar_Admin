package com.example.pukaaradmin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        loginBinding.loginScreenButton.setOnClickListener {
            val intent = Intent(this , Dashboard::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }
    }
}