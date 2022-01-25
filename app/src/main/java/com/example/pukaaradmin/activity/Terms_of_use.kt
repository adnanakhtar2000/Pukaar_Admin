package com.example.pukaaradmin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.ActivityTermsOfUseBinding

class Terms_of_use : AppCompatActivity() {
    private lateinit var termsOfUseBinding: ActivityTermsOfUseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        termsOfUseBinding = ActivityTermsOfUseBinding.inflate(layoutInflater)
        setContentView(termsOfUseBinding.root)

        termsOfUseBinding.backArrow16.setOnClickListener {
            finish()
        }
    }
}