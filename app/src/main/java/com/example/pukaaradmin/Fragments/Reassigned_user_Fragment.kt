package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Recycler_Adapters.Re_Assigned_user_recycler_Adapater
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
import com.example.pukaaradmin.Recycler_Adapters.Assigned_user_recycler_Adapater
import com.example.pukaaradmin.Recycler_Adapters.Availble_Therapist_recycler_Adapater
import com.example.pukaaradmin.Response.TherapistListResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentReassignedUserBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Reassigned_user_Fragment : Fragment() {
   private lateinit var reassignedUserBinding: FragmentReassignedUserBinding
    private lateinit var apiInterface: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        reassignedUserBinding = FragmentReassignedUserBinding.inflate(inflater , container , false)
        apiInterface = ApiClient.create()
        val therapistResponse = apiInterface.getUserTherapistResponse(CommonFunction.getToken(requireContext()),"client","reassigned")
        therapistResponse.enqueue( object : Callback<TherapistListResponse> {
            override fun onResponse(call: Call<TherapistListResponse>?, response: Response<TherapistListResponse>?) {

                if(response?.body() != null)
                {

                    val recyclerView = reassignedUserBinding.ReAssignedUserRecycler
                    recyclerView.adapter = Assigned_user_recycler_Adapater(response.body()!!.users.data , requireContext())
                    recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
                }
            }

            override fun onFailure(call: Call<TherapistListResponse>?, t: Throwable?) {
                Toast.makeText(requireContext(),"Error...",
                    Toast.LENGTH_LONG).show();
            }
        })

        return reassignedUserBinding.root
    }


}