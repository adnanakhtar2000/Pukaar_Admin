package com.example.pukaaradmin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.databinding.ActivityAddedTherapistBinding

class Added_Therapist : AppCompatActivity() {

    private  lateinit var addedTherapistBinding: ActivityAddedTherapistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addedTherapistBinding = ActivityAddedTherapistBinding.inflate(layoutInflater)
        setContentView(addedTherapistBinding.root)

addedTherapistBinding.addedScreenButton.setOnClickListener {
    val intent = Intent(this , Dashboard::class.java)
    startActivity(intent)
    overridePendingTransition(0,0)
}


    }
}