package com.example.pukaaradmin.Fragments

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.UsersData
import com.example.pukaaradmin.activity.Chat
import com.example.pukaaradmin.activity.Historical_Data
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
        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Please wait Data is Fetching...")
        progressDialog.setTitle("Data Fetching")
        progressDialog.setCancelable(false)
        progressDialog.show()
        val bundle : Bundle? = arguments
        val data: UsersData = arguments?.getParcelable<UsersData>("user data") as UsersData
        val id: String? = arguments?.getString("id","0")
        //therapist
        patientProfileBinding.patientNameProfile.text = data.first_name + " " + data.last_name

        if (data.client_profile != null){
            progressDialog.dismiss()
        patientProfileBinding.ans1.text = data.client_profile!!.orientation.toString()
        patientProfileBinding.ans2.text = data.client_profile!!.religion
        patientProfileBinding.ans3.text = data.client_profile!!.religion_identifier
        patientProfileBinding.ans4.text = data.client_profile!!.medicines
        patientProfileBinding.ans5.text = data.client_profile!!.sleeping_habit
        patientProfileBinding.ans6.text = data.client_profile!!.problem

        }
        patientProfileBinding.button2.setOnClickListener {
            val chat = Chat()
            chat.setId(id)
            val intent = Intent(requireActivity(), chat::class.java)
            //intent.putExtra("id",id)
            startActivity(intent)
        }


        patientProfileBinding.assignTheropist.setOnClickListener {
            var therapist = Assign_Therpaist_to_patient()
            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, therapist )
//            transaction.disallowAddToBackStack()
            transaction.commit()
        }
        patientProfileBinding.button.setOnClickListener{
            val intent = Intent(requireActivity(), Historical_Data::class.java)
            //intent.putExtra("id",id)
            intent.putExtra("history_key", data.id.toString())
            startActivity(intent)
        }

        return patientProfileBinding.root
    }


}