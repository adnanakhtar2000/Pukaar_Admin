package com.example.pukaaradmin.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentDashboardBinding


class Dashboard_Fragment : Fragment() {
private lateinit var dashboardBinding: FragmentDashboardBinding
private lateinit var userFragment: User_Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textView = requireActivity().findViewById<TextView>(R.id.title_toolbar)
        textView.setText("Pukaar")
        // Inflate the layout for this fragment
        dashboardBinding = FragmentDashboardBinding.inflate(inflater , container , false)

        dashboardBinding.cardView.setOnClickListener{
            userFragment = User_Fragment()
      fragmentManager?.beginTransaction()?.replace(R.id.container , userFragment)?.commit()
        }
        dashboardBinding.cardView2.setOnClickListener{
           val therapist_list = Therapist_List_Fragment()
            fragmentManager?.beginTransaction()?.replace(R.id.container , therapist_list)?.commit()
        }
        dashboardBinding.cardView4.setOnClickListener{
            val paymentsVerification = Payments_Verification()
            fragmentManager?.beginTransaction()?.replace(R.id.container , paymentsVerification)?.commit()
        }

        dashboardBinding.cardView5.setOnClickListener{
            val sessionSummary= Session_Summary()
            fragmentManager?.beginTransaction()?.replace(R.id.container , sessionSummary)?.commit()
        }
        return dashboardBinding.root
    }


}