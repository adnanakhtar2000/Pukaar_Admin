package com.example.pukaaradmin.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentPatientProfileBinding


class Patient_Profile : Fragment() {
   private lateinit var patientProfileBinding: FragmentPatientProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Patient Profile")
        patientProfileBinding= FragmentPatientProfileBinding.inflate(inflater , container , false)
        // Inflate the layout for this fragment
        return patientProfileBinding.root
    }


}