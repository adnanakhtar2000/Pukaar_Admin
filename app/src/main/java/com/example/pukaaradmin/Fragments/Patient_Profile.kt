package com.example.pukaaradmin.Fragments

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Recycler_Adapters.Pending_payments_recycler_Adapater
import com.example.pukaaradmin.Response.Therapist_Name
import com.example.pukaaradmin.Response.UserSessionResponse
import com.example.pukaaradmin.Response.UsersData
import com.example.pukaaradmin.activity.Chat
import com.example.pukaaradmin.activity.Daily_Diary
import com.example.pukaaradmin.activity.Historical_Data
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentPatientProfileBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class Patient_Profile : Fragment() {
   private lateinit var patientProfileBinding: FragmentPatientProfileBinding
    private lateinit var apiInterface: ApiInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Patient Profile")
        apiInterface = ApiClient.create()
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
 val call = apiInterface.getTherapist_name(CommonFunction.getToken(requireContext()) , data.id)
        call.enqueue(object : retrofit2.Callback<Therapist_Name> {
            override fun onResponse(
                call: Call<Therapist_Name>?,
                response: Response<Therapist_Name>?
            ) {
                if (response!!.body() != null){
                    patientProfileBinding.assignTheropist.text = response.body()!!.success.user.first_name + " " + response.body()!!.success.user.first_name
                    patientProfileBinding.notherapistAssign.text = ""
                }
                else{
                    patientProfileBinding.assignTheropist.setOnClickListener {
                        var therapist = Assign_Therpaist_to_patient()
                        val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                        transaction.addToBackStack("").add(R.id.container, therapist )
//            transaction.disallowAddToBackStack()
                        transaction.commit()
                    }

                }

            }

            override fun onFailure(call: Call<Therapist_Name>?, t: Throwable?) {
                Toast.makeText(requireContext() , t!!.message , Toast.LENGTH_LONG ).show()

            }
        })


        patientProfileBinding.button.setOnClickListener{
            val intent = Intent(requireActivity(), Historical_Data::class.java)
            //intent.putExtra("id",id)
            intent.putExtra("history_key", data.id.toString())
            startActivity(intent)
        }
        Toast.makeText(requireContext() , data.id.toString() , Toast.LENGTH_LONG ).show()
        patientProfileBinding.button3.setOnClickListener {

            var dailyDiary = Daily_Diary()
            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.addToBackStack("").add(R.id.container , dailyDiary)
          CommonFunction.saveClientid(requireContext() , data.id.toString())
//            transaction.disallowAddToBackStack()
            transaction.commit()
        }

        return patientProfileBinding.root
    }


}