package com.example.pukaaradmin.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pukaaradmin.R


class Therapist_Profile : Fragment() {

    private lateinit var therapistProfileBinding: com.example.pukaaradmin.databinding.FragmentTherapistProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Therapist Profile")
        therapistProfileBinding = com.example.pukaaradmin.databinding.FragmentTherapistProfileBinding.inflate(inflater , container , false)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_therapist__profile, container, false)
    }


}