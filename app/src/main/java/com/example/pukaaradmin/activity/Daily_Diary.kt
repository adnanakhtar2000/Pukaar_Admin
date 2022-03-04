package com.example.pukaaradmin.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.pukaaradmin.Adapters.Payment_Tab_Adapters
import com.example.pukaaradmin.Fragments.Approved_fragment
import com.example.pukaaradmin.Fragments.Daily_Diary_Day
import com.example.pukaaradmin.Fragments.Pending_Fragment
import com.example.pukaaradmin.Fragments.Rejected_Fragment
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentDailyDiaryBinding


class Daily_Diary : Fragment() {
    private lateinit var dailyDiaryBinding: FragmentDailyDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dailyDiaryBinding = FragmentDailyDiaryBinding.inflate(inflater , container , false)
        // Inflate the layout for this fragment
        val viewPager : ViewPager = dailyDiaryBinding.diaryViewpager
        val tabLayout = dailyDiaryBinding.dwm3
        val paymentTabAdapters = Payment_Tab_Adapters(childFragmentManager)
        paymentTabAdapters.addfragment(Daily_Diary_Day(), "Day")
        paymentTabAdapters.addfragment(Daily_Diary_Day() , "Week")
        paymentTabAdapters.addfragment(Daily_Diary_Day() , "Month")
        viewPager.adapter = paymentTabAdapters
        tabLayout.setupWithViewPager(viewPager)
        return dailyDiaryBinding.root
    }


}