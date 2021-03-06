package com.example.pukaaradmin.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.activity.Pukaar_Forum
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
      fragmentManager?.beginTransaction()?.addToBackStack("")?.add(R.id.container , userFragment)?.commit()
        }
        dashboardBinding.cardView2.setOnClickListener{
           val therapist_list = Therapist_List_Fragment()
            fragmentManager?.beginTransaction()?.addToBackStack("")?.add(R.id.container , therapist_list)?.commit()
        }
        dashboardBinding.cardView4.setOnClickListener{
            val paymentsVerification = Payments_Verification()
            fragmentManager?.beginTransaction()?.addToBackStack("")?.add(R.id.container , paymentsVerification)?.commit()
        }

        dashboardBinding.cardView5.setOnClickListener{
            val sessionSummary= Session_Summary()
            fragmentManager?.beginTransaction()?.addToBackStack("")?.add(R.id.container , sessionSummary)?.commit()
        }
        dashboardBinding.cardView3.setOnClickListener{

            fragmentManager?.beginTransaction()?.addToBackStack("")?.add(R.id.container , Notifications())?.commit()
        }
        dashboardBinding.cardView6.setOnClickListener{
           val intent = Intent(requireContext() , Pukaar_Forum::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        dashboardBinding.name.text = CommonFunction.getName(requireContext())
        return dashboardBinding.root
    }


}