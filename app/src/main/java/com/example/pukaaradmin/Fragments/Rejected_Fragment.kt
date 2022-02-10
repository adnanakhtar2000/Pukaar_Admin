package com.example.pukaaradmin.Fragments

import android.app.ProgressDialog
import com.example.pukaaradmin.Recycler_Adapters.Approved_payments_recycler_Adapater
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
import com.example.pukaaradmin.Recycler_Adapters.Availble_Therapist_recycler_Adapater
import com.example.pukaaradmin.Recycler_Adapters.Rejected_payments_recycler_Adapater
import com.example.pukaaradmin.Response.UserSessionResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentRejectedBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Rejected_Fragment : Fragment() {

private lateinit var rejectedBinding: FragmentRejectedBinding


    private lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rejectedBinding = FragmentRejectedBinding.inflate(inflater ,  container , false)
        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Please wait Data is Fetching...")
        progressDialog.setTitle("Data Fetching")
        progressDialog.setCancelable(false)
        progressDialog.show()
        val reccyler_view = rejectedBinding.rejectedPaymentRecycler
        apiInterface = ApiClient.create()
        val call = apiInterface.getUserSessionDetails(CommonFunction.getToken(requireContext()),"rejected")
        call.enqueue(object : Callback<UserSessionResponse> {
            override fun onResponse(
                call: Call<UserSessionResponse>?,
                response: Response<UserSessionResponse>?
            ) {
                if (response?.body() != null) {
                    progressDialog.dismiss()
                    val recyclerView = rejectedBinding.rejectedPaymentRecycler
                    recyclerView.adapter = Rejected_payments_recycler_Adapater(response.body()!!.data  ,requireContext())
                    recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
                    //setting data

                }
            }

            override fun onFailure(call: Call<UserSessionResponse>?, t: Throwable?) {

            }
        })


        return  rejectedBinding.root
    }


}