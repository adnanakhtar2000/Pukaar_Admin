package Fragments

import Recycler_Adapters.Re_Assigned_user_recycler_Adapater
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentReassignedUserBinding


class Reassigned_user_Fragment : Fragment() {
   private lateinit var reassignedUserBinding: FragmentReassignedUserBinding
    val profile_image : List<Int> = listOf(R.drawable.profile_image )
    val profile_name : List<String> = listOf("Nadia Khan" )
    val time : List<String> = listOf("12:23 AM" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        reassignedUserBinding = FragmentReassignedUserBinding.inflate(inflater , container , false)

        val recyclerView = reassignedUserBinding.ReAssignedUserRecycler
recyclerView.adapter = Re_Assigned_user_recycler_Adapater(profile_image , profile_name , time)
recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
        return reassignedUserBinding.root
    }


}