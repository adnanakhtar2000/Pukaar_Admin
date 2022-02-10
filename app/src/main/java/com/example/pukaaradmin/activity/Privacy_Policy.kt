package com.example.pukaaradmin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.ActivityPrivacyPolicyBinding

class Privacy_Policy : AppCompatActivity() {
    private lateinit var privacyPolicyBinding: ActivityPrivacyPolicyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        privacyPolicyBinding = ActivityPrivacyPolicyBinding.inflate(layoutInflater)
        setContentView(privacyPolicyBinding.root)
        privacyPolicyBinding.backArrow16.setOnClickListener {
            finish()
        }
    }
}