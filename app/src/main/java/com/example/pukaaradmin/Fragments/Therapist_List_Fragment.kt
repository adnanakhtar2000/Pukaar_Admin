package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Adapters.TherapistList_Tab_Adapters
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentTherapistListBinding


class Therapist_List_Fragment : Fragment() {

    private  lateinit var therapistListBinding: FragmentTherapistListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //change title of screen
        val textView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textView.setText("Therapist List")
        // Inflate the layout for this fragment
        therapistListBinding = FragmentTherapistListBinding.inflate(inflater , container , false)
        val viewPager : ViewPager = therapistListBinding.viewpagerTherapistList
        val tabLayout = therapistListBinding.tablayoutTherapistList
       //set Adapter
        val therapistlistTabAdapters = TherapistList_Tab_Adapters(childFragmentManager)
        therapistlistTabAdapters.addfragment(Availble_Therapist() , "Available Therapists")
        therapistlistTabAdapters.addfragment(UnAvailble_Therapist() , "Un-Available Therapists")
        viewPager.adapter = therapistlistTabAdapters
        tabLayout.setupWithViewPager(viewPager)





        return therapistListBinding.root
    }


}