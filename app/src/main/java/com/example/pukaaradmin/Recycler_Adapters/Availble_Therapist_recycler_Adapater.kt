package com.example.pukaaradmin.Recycler_Adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.Fragments.Patient_Profile
import com.example.pukaaradmin.Fragments.Therapist_Profile
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.TherapistListResponse
import com.example.pukaaradmin.Response.TherapistProfile
import com.example.pukaaradmin.Response.UsersData
import com.example.pukaaradmin.activity.Dashboard

class Availble_Therapist_recycler_Adapater(val data: ArrayList<UsersData>  ,val context: Context) : RecyclerView.Adapter<Availble_Therapist_recycler_Adapater.Availble_Therapist_viewholder>() {


    /* private List<DiaryResponse.FirstDatum.Datum> diaryResponseData;*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Availble_Therapist_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.user_screen , parent , false)
        return Availble_Therapist_viewholder(view)
    }

    override fun onBindViewHolder(holder: Availble_Therapist_viewholder, position: Int) {
       //holder.profile_image.setImageResource(profile_image[position])
        holder.patient_name.text = data[position].first_name +" " +data[position].last_name
        holder.time.text = CommonFunction.dateFormat(data[position].created_at)

        holder.itemView.setOnClickListener{


            var therapist_Profile = Therapist_Profile()

            val bundle = Bundle()
            bundle.putParcelable("data object" , data.get(position))
            therapist_Profile.arguments = bundle

            bundle.putParcelable("connected user" , data.get(position).therapist_profile.id)


            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, therapist_Profile )
            transaction.disallowAddToBackStack()
            transaction.commit()
        }
    }

    override fun getItemCount(): Int {
       return  data.size
    }

    class Availble_Therapist_viewholder(itemView: View): RecyclerView.ViewHolder(itemView)  {

        val profile_image = itemView.findViewById<ImageView>(R.id.profile_image)
        val patient_name =  itemView.findViewById<TextView>(R.id.profile_name)
        val time = itemView.findViewById<TextView>(R.id.time)


    }




}
