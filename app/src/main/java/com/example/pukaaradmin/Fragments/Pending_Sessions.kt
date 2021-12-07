package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Recycler_Adapters.All_Session_Recycler_Adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.databinding.FragmentPendingSessionsBinding


class Pending_Sessions : Fragment() {
  private  lateinit var pendingSessionsBinding: FragmentPendingSessionsBinding
    var patient_name : List<String> = listOf("Aline Js" , "Maliha Ashfeen" , "Aline Js")
    var date : List<String> = listOf("20/01/2021" , "20/01/2021" , "20/01/2021" )
    var time : List<String> = listOf("03:09PM" , "03:09PM" , "03:09PM" )
    var session_taken : List<String> = listOf("02" , "08" , "10")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pendingSessionsBinding = FragmentPendingSessionsBinding.inflate(inflater , container  , false)
        // Inflate the layout for this fragment

        val recyclerView = pendingSessionsBinding.pendingFragmentRecycler
        recyclerView.adapter = All_Session_Recycler_Adapter(patient_name , date , time , session_taken)
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
        return pendingSessionsBinding.root


    }


}