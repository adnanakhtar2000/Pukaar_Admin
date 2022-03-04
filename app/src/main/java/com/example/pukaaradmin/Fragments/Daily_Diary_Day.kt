package com.example.pukaaradmin.Fragments

import android.app.ProgressDialog
import android.content.SharedPreferences
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
import com.example.pukaaradmin.Recycler_Adapters.Daily_Diary_Adapter
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentDailyDiaryDayBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Daily_Diary_Day : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var dailyDiaryBinding: FragmentDailyDiaryDayBinding
    private lateinit var apiInterface: ApiInterface
    private lateinit var sharedPreference : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dailyDiaryBinding = FragmentDailyDiaryDayBinding.inflate(inflater , container , false)
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Patient Diary")
    val value = CommonFunction.getClientid(requireContext())



        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Please wait Data is Fetching...")
        progressDialog.setTitle("Data Fetching")
        progressDialog.setCancelable(false)
        progressDialog.show()
        //tab layout setting
        apiInterface = ApiClient.create()
        val therapistResponse = apiInterface.getClientDiary(CommonFunction.getToken(requireContext()),Integer.parseInt(value))
        therapistResponse?.enqueue( object : Callback<DailyDiary_Responses> {
            override fun onResponse(call: Call<DailyDiary_Responses>?, response: Response<DailyDiary_Responses>?) {
                CommonFunction.saveClientid(requireContext() , "")

                if(response?.body() != null)
                {
                    progressDialog.dismiss()
                    val recyclerView = dailyDiaryBinding.dailyDiaryRecyler
                    recyclerView.adapter = context?.let {
                        Daily_Diary_Adapter(response!!.body()!!.data  ,
                            it
                        )
                    }
                    recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
                    //setting data

                }
                else {
                    progressDialog.dismiss()
                    Toast.makeText(requireContext() , "No Data Availble" , Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<DailyDiary_Responses>?, t: Throwable?) {
                Toast.makeText(requireContext(),"Error...",
                    Toast.LENGTH_LONG).show();
            }
        })

        // Inflate the layout for this fragment
        return dailyDiaryBinding.root
    }


}