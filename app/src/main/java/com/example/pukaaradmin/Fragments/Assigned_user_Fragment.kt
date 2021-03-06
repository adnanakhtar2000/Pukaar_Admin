package com.example.pukaaradmin.Fragments

import android.app.ProgressDialog
import android.content.Context
import com.example.pukaaradmin.Recycler_Adapters.Assigned_user_recycler_Adapater
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.Response.TherapistListResponse
import com.example.pukaaradmin.Response.UsersData
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentAssignedUserBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Assigned_user_Fragment : Fragment() {

    private lateinit var mContext: Context
    private lateinit var assignedUserBinding: FragmentAssignedUserBinding
private lateinit var apiInterface: ApiInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       assignedUserBinding = FragmentAssignedUserBinding.inflate(inflater , container , false)
        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("please wait Data is Fetching...")
        progressDialog.setTitle("Data Fetching")
        progressDialog.setCancelable(false)
        progressDialog.show()
        apiInterface = ApiClient.create()
        val assignedUser = apiInterface.getUserTherapistResponse(CommonFunction.getToken(requireContext()),"client","assigned")
        assignedUser.enqueue( object : Callback<TherapistListResponse> {
            override fun onResponse(call: Call<TherapistListResponse>?, response: Response<TherapistListResponse>?) {

                if(response?.body() != null)
                {
                    if(mContext != null) {
                        progressDialog.dismiss()
                    val recyclerView = assignedUserBinding.assignedUserRecycler
                    recyclerView.adapter = Assigned_user_recycler_Adapater(
                        response.body()!!.users.data,
                        mContext

                    )

                    recyclerView.layoutManager =
                        LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
                }
                }
            }

            override fun onFailure(call: Call<TherapistListResponse>?, t: Throwable?) {
                Toast.makeText(requireContext(),"Error...",
                    Toast.LENGTH_LONG).show();
                progressDialog.dismiss()
            }
        })

        // setting Data



        return assignedUserBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context;
    }
}