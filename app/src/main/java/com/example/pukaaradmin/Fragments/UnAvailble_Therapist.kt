package com.example.pukaaradmin.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Recycler_Adapters.Availble_Therapist_recycler_Adapater
import com.example.pukaaradmin.Response.TherapistListResponse
import com.example.pukaaradmin.activity.Add_Therapist
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.FragmentAvailbleTherapistBinding
import com.example.pukaaradmin.databinding.FragmentUnAvailbleTherapistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UnAvailble_Therapist.newInstance] factory method to
 * create an instance of this fragment.
 */
class UnAvailble_Therapist : Fragment() {

    private lateinit var apiInterface: ApiInterface
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private  lateinit var unAvailbleTherapistBinding: FragmentUnAvailbleTherapistBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_un_availble__therapist, container, false)
        unAvailbleTherapistBinding = FragmentUnAvailbleTherapistBinding.inflate(inflater , container , false)
        apiInterface = ApiClient.create()
        val therapistResponse = apiInterface.getUserunavailbleTherapistResponse(CommonFunction.getToken(requireContext()),"therapist","inactive")
        therapistResponse.enqueue( object : Callback<TherapistListResponse> {
            override fun onResponse(call: Call<TherapistListResponse>?, response: Response<TherapistListResponse>?) {

                if(response?.body() != null)
                {
                    if(response.body()!!.users.data != null) {
                        val recyclerView = unAvailbleTherapistBinding.availbleTherapistRecyclerView
                        recyclerView.adapter = Availble_Therapist_recycler_Adapater(response.body()!!.users.data, requireContext())
                        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    }
                }
            }

            override fun onFailure(call: Call<TherapistListResponse>?, t: Throwable?) {
                Toast.makeText(requireContext(),"Error...",
                    Toast.LENGTH_LONG).show();
            }
        })


        //click on add therapist button

        unAvailbleTherapistBinding.addDoctors.setOnClickListener{
            val intent = Intent(context , Add_Therapist::class.java)
            startActivity(intent)
        }
        return unAvailbleTherapistBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UnAvailble_Therapist.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UnAvailble_Therapist().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}