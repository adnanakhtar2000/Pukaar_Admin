package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Recycler_Adapters.Approved_payments_recycler_Adapater
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentApprovedFragmentBinding


class Approved_fragment : Fragment() {

    private lateinit var approvedFragmentBinding: FragmentApprovedFragmentBinding

    val profile_image : List<Int> = listOf(R.drawable.profile_image , R.drawable.profile_image , R.drawable.profile_image)
    val profile_name : List<String> = listOf("Uzair Afzal" , "Bilal saeed" , "Uzma Bukhari")
    val time : List<String> = listOf("09:23 AM" , "12:10 PM", "06:50 AM")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        approvedFragmentBinding= FragmentApprovedFragmentBinding.inflate(inflater , container , false)
        // Inflate the layout for this fragment
        val reccyler_view = approvedFragmentBinding.approvedPaymentRecycler
        reccyler_view.adapter = Approved_payments_recycler_Adapater(profile_image , profile_name , time)
        reccyler_view.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)


        return approvedFragmentBinding.root
    }


}