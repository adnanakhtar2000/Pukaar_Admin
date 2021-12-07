package Fragments

import Recycler_Adapters.Availble_Therapist_recycler_Adapater
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.Add_Therapist
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentAvailbleTherapistBinding
import com.example.pukaaradmin.databinding.FragmentTherapistListBinding


class Availble_Therapist : Fragment() {

    private  lateinit var availbleTherapistBinding: FragmentAvailbleTherapistBinding
    val profile_image : List<Int> = listOf(R.drawable.profile_image , R.drawable.profile_image )
    val profile_name : List<String> = listOf("Mawra Hussian" , "Bilal Anjum" )
    val time : List<String> = listOf("01:23 AM" , "02:10 PM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        availbleTherapistBinding = FragmentAvailbleTherapistBinding.inflate(inflater , container , false)

        //tab layout setting
        val recyclerView = availbleTherapistBinding.availbleTherapistRecyclerView
        recyclerView.adapter = Availble_Therapist_recycler_Adapater(profile_image , profile_name , time)
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)

        //click on add therapist button
        
        availbleTherapistBinding.addDoctors.setOnClickListener{
            val intent = Intent(context , Add_Therapist::class.java)
            startActivity(intent)
        }
 /*availbleTherapistBinding.addDoctors.setOnClickListener {

     activity?.let{
         val intent = Intent (it, Add_Therapist::class.java)
         it.startActivity(intent)
     }

 }*/


        return availbleTherapistBinding.root
    }


}