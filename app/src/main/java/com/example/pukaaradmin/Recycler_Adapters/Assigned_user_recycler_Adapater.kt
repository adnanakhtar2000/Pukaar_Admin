package com.example.pukaaradmin.Recycler_Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.Fragments.Patient_Profile
import com.example.pukaaradmin.Fragments.Therapist_Profile
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.UsersData

class Assigned_user_recycler_Adapater(val data: ArrayList<UsersData> , val context: Context) : RecyclerView.Adapter<Unassigned_user_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Unassigned_user_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.user_screen , parent , false)
        return Unassigned_user_viewholder(view)
    }

    override fun onBindViewHolder(holder: Unassigned_user_viewholder, position: Int) {
        //holder.profile_image.setImageResource(data[position])
        holder.patient_name.text = data[position].first_name +" "+data[position].last_name
        holder.time.text = CommonFunction.dateFormat(data[position].created_at)

        holder.itemView.setOnClickListener{

   var patientProfile = Patient_Profile()

          val bundle = Bundle()
            bundle.putParcelable("user data" , data.get(position))
            bundle.putString("id" ,data.get(position).id.toString())
            patientProfile.arguments = bundle

            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, patientProfile )
            transaction.disallowAddToBackStack()
            transaction.commit()
        }
    }

    override fun getItemCount(): Int {
       return  data.size
    }
}
class Aassigned_user_viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

    val profile_image = itemView.findViewById<ImageView>(R.id.profile_image)
    val patient_name =  itemView.findViewById<TextView>(R.id.profile_name)
    val time = itemView.findViewById<TextView>(R.id.time)

}