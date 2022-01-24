package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Recycler_Adapters.Availble_Therapist_recycler_Adapater
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.activity.Add_Therapist
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.TherapistListResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentAvailbleTherapistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Availble_Therapist : Fragment() {

    private lateinit var apiInterface: ApiInterface
    private  lateinit var availbleTherapistBinding: FragmentAvailbleTherapistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        availbleTherapistBinding = FragmentAvailbleTherapistBinding.inflate(inflater , container , false)

        //tab layout setting
        apiInterface = ApiClient.create()
        val therapistResponse = apiInterface.getUserTherapistResponse(CommonFunction.getToken(requireContext()),"therapist","assigned")
        therapistResponse.enqueue( object : Callback<TherapistListResponse> {
            override fun onResponse(call: Call<TherapistListResponse>?, response: Response<TherapistListResponse>?) {

                if(response?.body() != null)
                {
                    val recyclerView = availbleTherapistBinding.availbleTherapistRecyclerView
                    recyclerView.adapter = context?.let {
                        Availble_Therapist_recycler_Adapater(response.body()!!.users.data  ,
                            it
                        )
                    }
                    recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
                    //setting data

                }
            }

            override fun onFailure(call: Call<TherapistListResponse>?, t: Throwable?) {
                Toast.makeText(requireContext(),"Error...",
                    Toast.LENGTH_LONG).show();
            }
        })


        //click on add therapist button
        
        availbleTherapistBinding.addDoctors.setOnClickListener{
            val intent = Intent(context , Add_Therapist::class.java)
            startActivity(intent)
        }
 /*availbleTherapistBinding.addDoctors.setOnClickListener {

     activity?.let{
         val intent = Intent (it, Add_Therapist::class.java)
         it.startActivity(intent)
     }

 }*/

        return availbleTherapistBinding.root
    }


}