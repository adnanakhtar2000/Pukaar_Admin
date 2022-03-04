package com.example.pukaaradmin.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Recycler_Adapters.Pending_payments_recycler_Adapater
import com.example.pukaaradmin.Recycler_Adapters.Session_Summary_Adapter


import com.example.pukaaradmin.Response.UserSessionResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentSessionSummaryDay1Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Session_Summary_day1 : Fragment() {
   private lateinit var sessionSummaryDay1Binding: FragmentSessionSummaryDay1Binding
    private lateinit var apiInterface: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        sessionSummaryDay1Binding = FragmentSessionSummaryDay1Binding.inflate(inflater , container , false)
        // Inflate the layout for this fragment
        val reccyler_view = sessionSummaryDay1Binding.sessionSummaryRecyclerViewDay
        apiInterface = ApiClient.create()
     val call = apiInterface.SessionsLogs1(CommonFunction.getToken(requireContext()))
        call!!.enqueue(object : Callback<Session_Summary_Response>{
            override fun onResponse(
                call: Call<Session_Summary_Response>,
                response: Response<Session_Summary_Response>
            ) {
                if (response.body() != null){
                    reccyler_view.adapter = Session_Summary_Adapter(response.body()!!.data  ,requireContext())
                    reccyler_view.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
                    //setting data
                }
            }

            override fun onFailure(call: Call<Session_Summary_Response>, t: Throwable) {
                Toast.makeText(requireContext() , t.message , Toast.LENGTH_LONG).show()
            }

        })

        return sessionSummaryDay1Binding.root
    }


}