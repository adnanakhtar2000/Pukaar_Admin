package com.example.pukaaradmin.Fragments

import com.example.pukaaradmin.Adapters.Payment_Tab_Adapters
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentPaymentsVerificationBinding


class Payments_Verification : Fragment() {
private lateinit var paymentsVerificationBinding: FragmentPaymentsVerificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textview : TextView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textview.setText("Payment Verification")
        // Inflate the layout for this fragment
        paymentsVerificationBinding = FragmentPaymentsVerificationBinding.inflate(inflater, container , false)

        val viewPager : ViewPager = paymentsVerificationBinding.paymnetViewpager
        val tabLayout = paymentsVerificationBinding.dwm2
        val paymentTabAdapters = Payment_Tab_Adapters(childFragmentManager)
        paymentTabAdapters.addfragment(Approved_fragment() , "Approved")
        paymentTabAdapters.addfragment(Pending_Fragment() , "Pending")
        paymentTabAdapters.addfragment(Rejected_Fragment() , "Rejected")
        viewPager.adapter = paymentTabAdapters
        tabLayout.setupWithViewPager(viewPager)
        return paymentsVerificationBinding.root
    }
}