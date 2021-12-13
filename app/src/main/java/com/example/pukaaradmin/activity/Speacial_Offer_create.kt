package com.example.pukaaradmin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.ActivitySpeacialOfferCreateBinding

class Speacial_Offer_create : AppCompatActivity() {

    private lateinit var speacialOfferCreateBinding: ActivitySpeacialOfferCreateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        speacialOfferCreateBinding = ActivitySpeacialOfferCreateBinding.inflate(layoutInflater)
        setContentView(speacialOfferCreateBinding.root)

        speacialOfferCreateBinding.addOfferButton.setOnClickListener {
            val intent = Intent(this , Dashboard::class.java)
            startActivity(intent)
        }

        speacialOfferCreateBinding.backArrow.setOnClickListener {
            val intent = Intent(this , Dashboard::class.java)
            startActivity(intent)
        }
    }
}