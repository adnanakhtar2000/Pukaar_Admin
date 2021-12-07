package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Recycler_Adapters.Assigned_user_recycler_Adapater
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentAssignedUserBinding


class Assigned_user_Fragment : Fragment() {

private lateinit var assignedUserBinding: FragmentAssignedUserBinding
    val profile_image : List<Int> = listOf(R.drawable.profile_image , R.drawable.profile_image )
    val profile_name : List<String> = listOf("Mawra Hussian" , "Bilal Anjum" )
    val time : List<String> = listOf("01:23 AM" , "02:10 PM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       assignedUserBinding = FragmentAssignedUserBinding.inflate(inflater , container , false)
        val recyclerView = assignedUserBinding.assignedUserRecycler
        recyclerView.adapter = Assigned_user_recycler_Adapater(profile_image , profile_name , time)
        recyclerView.layoutManager= LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)

        return assignedUserBinding.root
    }


}