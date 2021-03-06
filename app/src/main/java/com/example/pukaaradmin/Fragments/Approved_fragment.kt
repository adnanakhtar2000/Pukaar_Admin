package com.example.pukaaradmin.Fragments

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.Recycler_Adapters.Approved_payments_recycler_Adapater
import com.example.pukaaradmin.Response.UserSessionResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentApprovedFragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Approved_fragment : Fragment() {

    private lateinit var approvedFragmentBinding: FragmentApprovedFragmentBinding


    private lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        approvedFragmentBinding= FragmentApprovedFragmentBinding.inflate(inflater , container , false)
        // Inflate the layout for this fragment
        val reccyler_view = approvedFragmentBinding.approvedPaymentRecycler
        apiInterface = ApiClient.create()
       val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Please wait Data is Fetching...")
        progressDialog.setTitle("Data Fetching")
        progressDialog.setCancelable(false)
        progressDialog.show()
        val call = apiInterface.getUserSessionDetails(CommonFunction.getToken(requireContext()),"approved")
        call.enqueue(object : Callback<UserSessionResponse> {
            override fun onResponse(
                call: Call<UserSessionResponse>?,
                response: Response<UserSessionResponse>?
            ) {
                if (response?.body() != null) {
                    if(requireContext()!= null) {
                        progressDialog.dismiss()
                        val recyclerView = approvedFragmentBinding.approvedPaymentRecycler
                        recyclerView.adapter = Approved_payments_recycler_Adapater(
                            response.body()!!.data,
                            requireContext()
                        )
                        recyclerView.layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    }
                    //setting data
                }
            }

            override fun onFailure(call: Call<UserSessionResponse>?, t: Throwable?) {

            }
        })



        return approvedFragmentBinding.root
    }


}