package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Recycler_Adapters.Pending_payments_recycler_Adapater
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentPendingBinding


class Pending_Fragment : Fragment() {
private lateinit var pendingBinding: FragmentPendingBinding
    val profile_image : List<Int> = listOf(R.drawable.profile_image )
    val profile_name : List<String> = listOf("Uzair Afzal" )
    val time : List<String> = listOf("09:23 AM" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pendingBinding= FragmentPendingBinding.inflate(inflater , container , false )
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        val reccyler_view = pendingBinding.pendingPaymentRecycler
        reccyler_view.adapter = Pending_payments_recycler_Adapater(profile_image , profile_name , time)
        reccyler_view.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)


        return pendingBinding.root
    }


}