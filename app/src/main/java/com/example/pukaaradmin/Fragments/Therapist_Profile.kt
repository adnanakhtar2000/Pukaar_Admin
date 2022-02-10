package com.example.pukaaradmin.Fragments

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Recycler_Adapters.Availble_Therapist_recycler_Adapater
import com.example.pukaaradmin.Response.TherapistListResponse
import com.example.pukaaradmin.Response.TherapistProfile
import com.example.pukaaradmin.Response.UsersData
import com.example.pukaaradmin.apiinterface.ApiInterface
import kotlinx.android.synthetic.main.activity_add_therapist.*
import kotlinx.android.synthetic.main.fragment_therapist__profile.*


class Therapist_Profile : Fragment() {

    private lateinit var usersData: UsersData
    private lateinit var therapistProfileBinding: com.example.pukaaradmin.databinding.FragmentTherapistProfileBinding
  private  lateinit var apiInterface: ApiInterface


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
        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Please wait Data is Fetching...")
        progressDialog.setTitle("Data Fetching")
        progressDialog.setCancelable(false)
        progressDialog.show()
        val bundle : Bundle? = arguments
        val data: UsersData = arguments?.getParcelable<UsersData>("dataobject") as UsersData

        /*val data1: TherapistProfile = arguments?.getParcelable<TherapistProfile>("data1 object") as TherapistProfile*/


        therapistProfileBinding.doctorName.text = data.first_name + " " + data.last_name
        therapistProfileBinding.docType.text = data?.therapist_profile?.type_of_doctor
        therapistProfileBinding.docAbout.text = data?.therapist_profile?.about
        therapistProfileBinding.introduction.text = data?.therapist_profile?.introduction
        therapistProfileBinding.docEducation.text = data?.therapist_profile?.education
        progressDialog.dismiss()

      therapistProfileBinding.button1.setOnClickListener {
            var connectedUser = Connected_User()





          val bundle = Bundle()
          bundle.putString("dataobject1" , data.id.toString())
          connectedUser.arguments = bundle
          fragmentManager?.beginTransaction()?.replace(R.id.container , connectedUser)?.commit()
        }

        return therapistProfileBinding.root

    }


}