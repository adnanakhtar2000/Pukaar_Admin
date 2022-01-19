package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Recycler_Adapters.All_Session_Recycler_Adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Recycler_Adapters.Donated_Session_Recycler_Adapter
import com.example.pukaaradmin.Recycler_Adapters.Pending_payments_recycler_Adapater
import com.example.pukaaradmin.Response.UserData_payments
import com.example.pukaaradmin.Response.UserSessionResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentDonatedSessionsBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class Donated_Sessions : Fragment() {

private  lateinit var donatedSessionsBinding: FragmentDonatedSessionsBinding
    private lateinit var apiInterface: ApiInterface
    private lateinit var userSessionResponse : UserData_payments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Donated Sessions")
        donatedSessionsBinding = FragmentDonatedSessionsBinding.inflate(inflater , container , false)
        apiInterface = ApiClient.create()

        val Call = apiInterface.getUserDonationSessionDetails(CommonFunction.getToken(requireContext()) , "pending" , "yes")
        Call.enqueue(object : retrofit2.Callback<UserSessionResponse> {
            override fun onResponse(
                call: Call<UserSessionResponse>?,
                response: Response<UserSessionResponse>?
            ) {
                if (response?.body() != null) {
                    val reccyler_view = donatedSessionsBinding.donatedSessionsRecycler
                    reccyler_view.adapter = Donated_Session_Recycler_Adapter(response.body()!!.data )
                    reccyler_view.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
                    //setting data


                }
            }

            override fun onFailure(call: Call<UserSessionResponse>?, t: Throwable?) {

            }
        })

        /*   // Inflate the layout for this fragment
           val recyclerView = donatedSessionsBinding.donatedSessionsRecycler
           recyclerView.adapter = All_Session_Recycler_Adapter(patient_name , date , time , session_taken)
           recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
   */

        return donatedSessionsBinding.root
    }


}