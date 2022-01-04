package com.example.pukaaradmin.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentConnectedUserBinding


class Connected_User : Fragment() {
    private lateinit var connectedUserBinding: FragmentConnectedUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        connectedUserBinding = FragmentConnectedUserBinding.inflate(inflater , container , false)

        // Inflate the layout for this fragment
        return connectedUserBinding.root
    }


}