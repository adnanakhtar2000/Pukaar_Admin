package Fragments


import Recycler_Adapters.Unassigned_user_recycler_Adapater
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.FragmentUnAssignedUserFragmentBinding


class UnAssigned_User_fragment : Fragment() {

    private lateinit var unAssignedUserFragmentBinding: FragmentUnAssignedUserFragmentBinding
    val profile_image : List<Int> = listOf(R.drawable.profile_image , R.drawable.profile_image , R.drawable.profile_image)
    val profile_name : List<String> = listOf("Uzair Afzal" , "Bilal saeed" , "Uzma Bukhari")
    val time : List<String> = listOf("09:23 AM" , "12:10 PM", "06:50 AM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        unAssignedUserFragmentBinding = FragmentUnAssignedUserFragmentBinding.inflate(inflater , container , false)

        val reccyler_view = unAssignedUserFragmentBinding.unassignedUserRecycler
        reccyler_view.adapter = Unassigned_user_recycler_Adapater(profile_image , profile_name , time)
        reccyler_view.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
        return unAssignedUserFragmentBinding.root
    }

}