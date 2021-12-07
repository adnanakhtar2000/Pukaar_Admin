package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Recycler_Adapters.All_Session_Recycler_Adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentDonatedSessionsBinding


class Donated_Sessions : Fragment() {

private  lateinit var donatedSessionsBinding: FragmentDonatedSessionsBinding
    var patient_name : List<String> = listOf("Aline Js" , "Maliha Ashfeen" )
    var date : List<String> = listOf("20/01/2021" , "20/01/2021" )
    var time : List<String> = listOf("03:09PM" , "03:09PM" )
    var session_taken : List<String> = listOf("02" , "08")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Donated Sessions")
        donatedSessionsBinding = FragmentDonatedSessionsBinding.inflate(inflater , container , false)
        // Inflate the layout for this fragment
        val recyclerView = donatedSessionsBinding.donatedSessionsRecycler
        recyclerView.adapter = All_Session_Recycler_Adapter(patient_name , date , time , session_taken)
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)


        return donatedSessionsBinding.root
    }


}