package com.example.pukaaradmin.Recycler_Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.UserData_payments
import com.example.pukaaradmin.Response.UsersData

class Rejected_payments_recycler_Adapater(val paymentdata: ArrayList<UserData_payments>, val context: Context): RecyclerView.Adapter<Rejected_payments_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rejected_payments_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.user_screen , parent , false)
        return Rejected_payments_viewholder(view)
    }

    override fun onBindViewHolder(holder: Rejected_payments_viewholder, position: Int) {
    //   holder.profile_image.setImageResource(profile_image[position])
        holder.patient_name.text= paymentdata[position].user.first_name + "" + paymentdata[position].user.last_name
        holder.time.text = CommonFunction.dateFormat(paymentdata[position].user.created_at)
    }

    override fun getItemCount(): Int {
       return paymentdata.size
    }
}
class Rejected_payments_viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

    val profile_image = itemView.findViewById<ImageView>(R.id.profile_image)
    val patient_name =  itemView.findViewById<TextView>(R.id.profile_name)
    val time = itemView.findViewById<TextView>(R.id.time)

}