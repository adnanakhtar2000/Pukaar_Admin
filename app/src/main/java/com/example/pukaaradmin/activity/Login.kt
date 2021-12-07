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
            if (email_validation() && password_validation()){
                val intent = Intent(this , Dashboard::class.java)
                startActivity(intent)
                overridePendingTransition(0,0)}
        }
    }

    private  fun email_validation() : Boolean{
        val email_validation = loginBinding.mainEmail.text.toString()

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        if (email_validation.isEmpty() ){
            loginBinding.mainEmail.setError("Email filed cannot be empty")
            return false
        }
        if (!email_validation.matches(emailPattern.toRegex()) ){
            loginBinding.mainEmail.setError("Email Adress in invalid")
            return false
        }
        else return true
    }

    private  fun password_validation(): Boolean{
        val password_validation = loginBinding.mainPassword.text.toString().trim()
        if (password_validation.isEmpty() ){
            loginBinding.mainPassword.setError("Password must be Entered")
            return false
        }
        else{
            return true
        }
    }
}