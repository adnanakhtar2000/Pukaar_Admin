package Fragments

import Recycler_Adapters.All_Session_Recycler_Adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentOneOnoneSessionsBinding


class oneOnone_sessions : Fragment() {

    private lateinit var oneOnoneSessionsBinding: FragmentOneOnoneSessionsBinding

    var patient_name : List<String> = listOf("Aline Js" , "Maliha Ashfeen" )
    var date : List<String> = listOf("20/01/2021" , "20/01/2021" )
    var time : List<String> = listOf("03:09PM" , "03:09PM" )
    var session_taken : List<String> = listOf("02" , "08")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        oneOnoneSessionsBinding = FragmentOneOnoneSessionsBinding.inflate(inflater , container , false)
        // Inflate the layout for this fragment
        val recyclerView = oneOnoneSessionsBinding.oneOnoneSessionRecycler
        recyclerView.adapter = All_Session_Recycler_Adapter(patient_name , date , time , session_taken)
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)



        return oneOnoneSessionsBinding.root
    }


}