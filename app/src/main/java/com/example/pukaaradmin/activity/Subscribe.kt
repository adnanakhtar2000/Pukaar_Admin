package com.example.pukaaradmin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.ActivitySubscribeBinding

class Subscribe : AppCompatActivity() {
    private lateinit var subscribeBinding: ActivitySubscribeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeBinding = ActivitySubscribeBinding.inflate(layoutInflater)
        setContentView(subscribeBinding.root)
        subscribeBinding.backArrow27.setOnClickListener {
            finish()
        }
    }
}