package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Adapters.Session_Summary_Tab_Adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentSessionSummaryBinding


class Session_Summary : Fragment() {

    private lateinit var sessionSummaryBinding: FragmentSessionSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Session Summary")
        sessionSummaryBinding= FragmentSessionSummaryBinding.inflate(inflater , container , false)
        // Inflate the layout for this fragment

        val viewpager : ViewPager = sessionSummaryBinding.sessionSummaryViewpager
        val tabLayout = sessionSummaryBinding.dwm3



        //intilize Adapter
        val sessionSummaryTabAdapter = Session_Summary_Tab_Adapter(childFragmentManager)
        sessionSummaryTabAdapter.addfragment(Session_Summary_Day() , "All Sessions")
        sessionSummaryTabAdapter.addfragment(Session_Summary_Day() , "Pending")
        sessionSummaryTabAdapter.addfragment(Session_Summary_Day() , "1 On 1 Sessions")
        viewpager.adapter = sessionSummaryTabAdapter
        tabLayout.setupWithViewPager(viewpager)
        return sessionSummaryBinding.root
    }


}