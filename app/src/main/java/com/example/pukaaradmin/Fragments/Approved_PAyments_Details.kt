package com.example.pukaaradmin.Fragments

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Recycler_Adapters.Payment_Details_Recycler
import com.example.pukaaradmin.Response.PaymentDetailsResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentApprovedPAymentsDetailsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Approved_PAyments_Details : Fragment() {
  private lateinit var approvedPAymentsDetailsBinding: FragmentApprovedPAymentsDetailsBinding
    private lateinit var apiInterface: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        approvedPAymentsDetailsBinding = FragmentApprovedPAymentsDetailsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Payment Details")
        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Please wait Data is Fetching...")
        progressDialog.setTitle("Data Fetching")
        progressDialog.setCancelable(false)
        progressDialog.show()
        val strtext = requireArguments().getString("YourKey")
        apiInterface = ApiClient.create()
        val call = apiInterface.getUserSessionPaymentDetails(CommonFunction.getToken(requireContext()),"100" , strtext.toString())
        call.enqueue(object : Callback<PaymentDetailsResponse> {
            override fun onResponse(
                call: Call<PaymentDetailsResponse>?,
                response: Response<PaymentDetailsResponse>?
            ) {
                if (response?.body() != null) {
progressDialog.dismiss()
                    val reccyler_view = approvedPAymentsDetailsBinding.approvedPaymentRecycler

                    reccyler_view.adapter = Payment_Details_Recycler(response!!.body()!!.data  ,requireContext())
                    reccyler_view.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
                    //setting data

                }
                else {
                    progressDialog.dismiss()
                    Toast.makeText(requireContext() , "Body null" , Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<PaymentDetailsResponse>?, t: Throwable?) {
                progressDialog.dismiss()
                Toast.makeText(requireContext() , t!!.message , Toast.LENGTH_LONG).show()
            }
        })

        return approvedPAymentsDetailsBinding.root
    }


    }
