package com.example.pukaaradmin.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.UsersData
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
        val bundle : Bundle? = arguments
        val data: UsersData = arguments?.getParcelable<UsersData>("user data") as UsersData
        //therapist
        patientProfileBinding.patientNameProfile.text = data.first_name + " " + data.last_name

        if (data.client_profile != null){
        patientProfileBinding.ans1.text = data.client_profile.orientation.toString()
        patientProfileBinding.ans2.text = data.client_profile.religion
        patientProfileBinding.ans3.text = data.client_profile.religion_identifier
        patientProfileBinding.ans4.text = data.client_profile.medicines
        patientProfileBinding.ans5.text = data.client_profile.sleeping_habit
        patientProfileBinding.ans6.text = data.client_profile.problem
        }

        return patientProfileBinding.root
    }


}