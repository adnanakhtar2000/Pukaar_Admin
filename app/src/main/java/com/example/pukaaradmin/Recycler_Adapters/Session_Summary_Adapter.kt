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
import com.example.pukaaradmin.activity.Data_Session
import com.example.pukaaradmin.activity.Session_Summary_Response
import com.example.pukaaradmin.apiinterface.ApiInterface
import kotlinx.android.synthetic.main.fragment_dashboard_.*
import kotlinx.android.synthetic.main.payment_deatils_popup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Session_Summary_Adapter(val data : List<Data_Session>, val context: Context): RecyclerView.Adapter<Session_Summary_Viewholder>() {

    lateinit var apiInterface : ApiInterface


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Session_Summary_Viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.session_summarylayout , parent , false)
        return Session_Summary_Viewholder(view)
    }

    override fun onBindViewHolder(holder: Session_Summary_Viewholder, position: Int) {
        //holder.profile_image.setImageResource(profile_image[position])
        holder.doc_name.text =
            data[position].therapist.first_name + " " + data[position].therapist.last_name
        holder.client_name.text =
            data[position].client.first_name + " " + data[position].client.last_name
        holder.sessionTaken1.text = data[position].session_taken
        holder.date_time_Session.text =  data[position].session_taken_time
    }

    override fun getItemCount(): Int {
        return  data.size
    }
}
class Session_Summary_Viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

    val doc_name = itemView.findViewById<TextView>(R.id.doc_name)
    val client_name =  itemView.findViewById<TextView>(R.id.client_name)
    val date_time_Session = itemView.findViewById<TextView>(R.id.date_time_Session)
    val sessionTaken1 = itemView.findViewById<TextView>(R.id.sessionTaken1)

}