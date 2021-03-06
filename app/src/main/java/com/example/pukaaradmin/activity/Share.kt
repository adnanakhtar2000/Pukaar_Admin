package com.example.pukaaradmin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.databinding.ActivityShareBinding

class Share : AppCompatActivity() {

    private lateinit var shareBinding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shareBinding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(shareBinding.root)
        shareBinding.backArrow26.setOnClickListener {
            finish()
        }

    }
}