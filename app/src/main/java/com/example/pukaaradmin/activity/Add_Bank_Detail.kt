package com.example.pukaaradmin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.ActivityAddBankDetailBinding
import com.example.pukaaradmin.databinding.ActivityAddTherapistBinding

class Add_Bank_Detail : AppCompatActivity() {
    private  lateinit var  addBankDetailBinding: ActivityAddBankDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addBankDetailBinding = ActivityAddBankDetailBinding.inflate(layoutInflater)
        setContentView(addBankDetailBinding.root)

        addBankDetailBinding.addBankButton.setOnClickListener {
            val intent = Intent(this , Dashboard::class.java)
            startActivity(intent)
        }
    }
}