package com.example.pukaaradmin.Recycler_Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.Fragments.Connected_User
import com.example.pukaaradmin.Fragments.Therapist_Profile
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.Client
import com.example.pukaaradmin.Response.User
import com.example.pukaaradmin.Response.UserData_payments
import com.example.pukaaradmin.Response.UsersData

class Connected_user_recycler_Adapater(val connected_user_data: ArrayList<Client>, val context: Context): RecyclerView.Adapter<Connexted_user_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Connexted_user_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.user_screen , parent , false)
        return Connexted_user_viewholder(view)
    }

    override fun onBindViewHolder(holder: Connexted_user_viewholder, position: Int) {
    //   holder.profile_image.setImageResource(profile_image[position])
        holder.patient_name.text= connected_user_data[position].user.first_name + " " + connected_user_data[position].user.last_name
        holder.time.text = CommonFunction.dateFormat(connected_user_data[position].user.created_at)


    }

    override fun getItemCount(): Int {
       return  connected_user_data.size
    }
}
class Connexted_user_viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

    val profile_image = itemView.findViewById<ImageView>(R.id.profile_image)
    val patient_name =  itemView.findViewById<TextView>(R.id.profile_name)
    val time = itemView.findViewById<TextView>(R.id.time)

}