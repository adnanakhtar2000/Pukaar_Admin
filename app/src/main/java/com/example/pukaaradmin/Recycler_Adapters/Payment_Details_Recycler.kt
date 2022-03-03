package com.example.pukaaradmin.Recycler_Adapters

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.Fragments.Approved_PAyments_Details
import com.example.pukaaradmin.Fragments.Payment_picture
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.PaymentDetails
import com.example.pukaaradmin.Response.PaymentDetails_Data
import com.example.pukaaradmin.Response.UserData_payments
import com.example.pukaaradmin.apiinterface.ApiInterface
import kotlinx.android.synthetic.main.fragment_dashboard_.*
import kotlinx.android.synthetic.main.payment_deatils_popup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Payment_Details_Recycler(val approvedpaymentdata: PaymentDetails, val context: Context): RecyclerView.Adapter<Payment_Details_viewholder>() {

    lateinit var apiInterface : ApiInterface


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Payment_Details_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.payment_detal_screen , parent , false)
        return Payment_Details_viewholder(view)
    }

    override fun onBindViewHolder(holder: Payment_Details_viewholder, position: Int) {
        //holder.profile_image.setImageResource(profile_image[position])
        holder.dateandtimeapp.text= CommonFunction.dateFormat(approvedpaymentdata.data[position].created_at)
        holder.app_cost.text = approvedpaymentdata.data[position].cost
        holder.app_sessions.text = approvedpaymentdata.data[position].number_of_sessions

        holder.app_reciept.setOnClickListener {
            val paymentPicture = Payment_picture()
            val args = Bundle()
            args.putString("YourKey1", approvedpaymentdata.data[position].picture)
            paymentPicture.setArguments(args)

            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction?.addToBackStack("")?.add(R.id.container, paymentPicture )

            transaction.commit()
        }
    }

    override fun getItemCount(): Int {
        return  approvedpaymentdata.data.size
    }
}
class Payment_Details_viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

    val app_reciept = itemView.findViewById<ImageView>(R.id.app_reciept)
    val dateandtimeapp =  itemView.findViewById<TextView>(R.id.dateandtimeapp)
    val app_sessions = itemView.findViewById<TextView>(R.id.app_sessions)
    val app_cost = itemView.findViewById<TextView>(R.id.app_cost)

}