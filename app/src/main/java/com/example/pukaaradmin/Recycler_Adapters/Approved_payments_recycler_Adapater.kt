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
import com.example.pukaaradmin.Fragments.Approved_PAyments_Details
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.UserData_payments

class Approved_payments_recycler_Adapater(val paymentdata: ArrayList<UserData_payments>, val context: Context): RecyclerView.Adapter<Approved_payments_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Approved_payments_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.user_screen , parent , false)
        return Approved_payments_viewholder(view)
    }

    override fun onBindViewHolder(holder: Approved_payments_viewholder, position: Int) {
    //   holder.profile_image.setImageResource(profile_image[position])
        holder.patient_name.text= paymentdata[position].user.first_name + "" + paymentdata[position].user.last_name
        holder.time.text = CommonFunction.dateFormat(paymentdata[position].user.created_at)
        holder.itemView.setOnClickListener {
            val approvedPaymentsDetails = Approved_PAyments_Details()
            val args = Bundle()
            args.putString("YourKey", paymentdata[position].user.id.toString())
            approvedPaymentsDetails.setArguments(args)

            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction?.addToBackStack("")?.add(R.id.container, approvedPaymentsDetails )

            transaction.commit()
        }
    }

    override fun getItemCount(): Int {
       return  paymentdata.size
    }
}
class Approved_payments_viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

    val profile_image = itemView.findViewById<ImageView>(R.id.profile_image)
    val patient_name =  itemView.findViewById<TextView>(R.id.profile_name)
    val time = itemView.findViewById<TextView>(R.id.time)

}