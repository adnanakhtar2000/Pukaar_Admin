package com.example.pukaaradmin.Recycler_Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.R

class All_Session_Recycler_Adapter(val pateint_name : List<String> , val date : List<String> , val time : List<String> , val session_taken : List<String>) : RecyclerView.Adapter<All_Session_Recycler_Adapter.All_Session_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): All_Session_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater  .inflate(R.layout.all_session_history , parent , false)
        return All_Session_viewholder(view)
    }

    override fun onBindViewHolder(holder: All_Session_viewholder, position: Int) {
        holder.patient_name.text = pateint_name[position]
        holder.date.text =date[position]
        holder.time.text=time[position]
        holder.session_taken.text =session_taken[position]
    }

    override fun getItemCount(): Int {
        return pateint_name.size
    }
    class All_Session_viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

        var patient_name = itemView.findViewById<TextView>(R.id.patient_name)
        var date = itemView.findViewById<TextView>(R.id.date)
        var time = itemView.findViewById<TextView>(R.id.time)
        var session_taken = itemView.findViewById<TextView>(R.id.session_taken)

    }
}
