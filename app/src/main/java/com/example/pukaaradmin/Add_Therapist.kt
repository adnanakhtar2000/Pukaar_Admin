package com.example.pukaaradmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.databinding.ActivityAddTherapistBinding

class Add_Therapist : AppCompatActivity() {

    private  lateinit var addTherapistBinding: ActivityAddTherapistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addTherapistBinding=ActivityAddTherapistBinding.inflate(layoutInflater)
        setContentView(addTherapistBinding.root)

        addTherapistBinding.addDoctorsButton1.setOnClickListener {
            val intent = Intent(this , Added_Therapist::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }


    }
}