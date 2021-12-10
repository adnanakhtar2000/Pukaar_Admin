package com.example.pukaaradmin.Fragments


import com.example.pukaaradmin.Recycler_Adapters.Unassigned_user_recycler_Adapater
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
import com.example.pukaaradmin.Response.TherapistListResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentUnAssignedUserFragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UnAssigned_User_fragment : Fragment() {

    private lateinit var unAssignedUserFragmentBinding: FragmentUnAssignedUserFragmentBinding
    private lateinit var apiInterface: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        unAssignedUserFragmentBinding = FragmentUnAssignedUserFragmentBinding.inflate(inflater , container , false)

        apiInterface = ApiClient.create()
        val unassignedUser = apiInterface.getUserTherapistResponse(CommonFunction.getToken(requireContext()),"client","unassigned")
        unassignedUser.enqueue( object : Callback<TherapistListResponse> {
            override fun onResponse(call: Call<TherapistListResponse>?, response: Response<TherapistListResponse>?) {

                if(response?.body() != null)
                {
                    val reccyler_view = unAssignedUserFragmentBinding.unassignedUserRecycler
                    reccyler_view.adapter = Assigned_user_recycler_Adapater(response.body()!!.users.data)
                    reccyler_view.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
                }
            }

            override fun onFailure(call: Call<TherapistListResponse>?, t: Throwable?) {
                Toast.makeText(requireContext(),"Error...",
                    Toast.LENGTH_LONG).show();
            }
        })

        return unAssignedUserFragmentBinding.root
    }

}