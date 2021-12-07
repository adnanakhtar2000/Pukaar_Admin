package Fragments

import Recycler_Adapters.Approved_payments_recycler_Adapater
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentRejectedBinding


class Rejected_Fragment : Fragment() {

private lateinit var rejectedBinding: FragmentRejectedBinding

    val profile_image : List<Int> = listOf(R.drawable.profile_image , R.drawable.profile_image )
    val profile_name : List<String> = listOf("Uzair Afzal" , "Bilal saeed" ,)
    val time : List<String> = listOf("09:23 AM" , "12:10 PM")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rejectedBinding = FragmentRejectedBinding.inflate(inflater ,  container , false)

        val reccyler_view = rejectedBinding.rejectedPaymentRecycler
        reccyler_view.adapter = Approved_payments_recycler_Adapater(profile_image , profile_name , time)
        reccyler_view.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)


        return  rejectedBinding.root
    }


}