package com.example.pukaaradmin.Fragments

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
import com.example.pukaaradmin.Recycler_Adapters.Connected_user_recycler_Adapater
import com.example.pukaaradmin.Response.Client
import com.example.pukaaradmin.Response.ConnectUserResponse
import com.example.pukaaradmin.Response.UsersData
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentConnectedUserBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Connected_User : Fragment() {
    private lateinit var connectedUserBinding: FragmentConnectedUserBinding
    private lateinit var apiInterface : ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Connected User")
        connectedUserBinding = FragmentConnectedUserBinding.inflate(inflater , container , false)
        apiInterface = ApiClient.create()

        val bundle : String? = requireArguments().getString("dataobject1")

       /* val data: Therapist_Profile = arguments?.getParcelable<Therapist_Profile>("dataobject1") as Therapist_Profile*/
        val call = apiInterface.getConnectedUserResponse(CommonFunction.getToken(requireContext()),bundle.toString())
        call.enqueue(object : Callback<ConnectUserResponse> {
            override fun onResponse(
                call: Call<ConnectUserResponse>?,
                response: Response<ConnectUserResponse>?
            ) {
                if (response?.body() != null) {
                    if(requireContext()!= null) {
                        val reccyler_view = connectedUserBinding.connectedUserRecycler
                        reccyler_view.adapter = Connected_user_recycler_Adapater(response.body()!!.user.therapist_profile.client , requireContext())
                        // response.body()!!.user.therapist_profile.client       // pass this list to adapter
                        // response.body()!!.user.therapist_profile.client.get(position).user.first_name   // pass in adapter class for showing data
                        reccyler_view.layoutManager =
                            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                    }
                    //setting data
                }
            }

            override fun onFailure(call: Call<ConnectUserResponse>?, t: Throwable?) {

            }
        })
        // Inflate the layout for this fragment
        return connectedUserBinding.root
    }


}