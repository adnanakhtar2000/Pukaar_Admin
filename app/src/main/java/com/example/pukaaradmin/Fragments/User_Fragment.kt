package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Adapters.User_Tab_Adapters
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentUserBinding


class User_Fragment : Fragment() {
private  lateinit var userBinding: FragmentUserBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //change title
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Users")
        // Inflate the layout for this fragment
        userBinding = FragmentUserBinding.inflate(inflater , container , false  )



        val viewpager : ViewPager = userBinding.viewpager
        val tabLayout = userBinding.dwm1



        //intilize Adapter
        val user_tab_fragment = User_Tab_Adapters(childFragmentManager)
        user_tab_fragment.addfragment(UnAssigned_User_fragment() , "Unassigned")
        user_tab_fragment.addfragment(Assigned_user_Fragment() , "Assigned")
        user_tab_fragment.addfragment(Reassigned_user_Fragment() , "Re-Assigned")

        viewpager.adapter = user_tab_fragment
        tabLayout.setupWithViewPager(viewpager)
        return userBinding.root
    }

}