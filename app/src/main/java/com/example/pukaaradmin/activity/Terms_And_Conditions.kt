package com.example.pukaaradmin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.ActivityTermsAndConditionsBinding

class Terms_And_Conditions : AppCompatActivity() {
    private lateinit var termsAndConditionsBinding: ActivityTermsAndConditionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        termsAndConditionsBinding = ActivityTermsAndConditionsBinding.inflate(layoutInflater)
        setContentView(termsAndConditionsBinding.root)
        termsAndConditionsBinding.backArrow.setOnClickListener {
            finish()
        }
    }
}