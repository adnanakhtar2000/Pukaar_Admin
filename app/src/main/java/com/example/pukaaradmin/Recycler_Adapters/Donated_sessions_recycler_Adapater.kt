package com.example.pukaaradmin.Recycler_Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.UserData_payments

class Donated_Session_Recycler_Adapter(val paymentdata: ArrayList<UserData_payments>) : RecyclerView.Adapter<Donated_Session_Recycler_Adapter.Donated_Session_viewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Donated_Session_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater  .inflate(R.layout.all_session_history , parent , false)
        return Donated_Session_viewholder(view)
    }

    override fun onBindViewHolder(holder: Donated_Session_viewholder, position: Int) {
        holder.patient_name.text = paymentdata[position].user.first_name + " " + paymentdata[position].user.last_name
        holder.date.text = CommonFunction.dateFormat(paymentdata[position].user.created_at)
        holder.session_taken.text = paymentdata.get(position).number_of_sessions.toString()

    }

    override fun getItemCount(): Int {
        return paymentdata.size
    }
    class Donated_Session_viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

        var patient_name = itemView.findViewById<TextView>(R.id.patient_name)
        var date = itemView.findViewById<TextView>(R.id.date)

        var session_taken = itemView.findViewById<TextView>(R.id.session_taken)

    }
}
