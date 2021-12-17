package com.example.pukaaradmin.Recycler_Adapters

import android.app.Dialog
import android.content.Context
import android.view.*
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.UserData_payments
import kotlinx.android.synthetic.main.fragment_dashboard_.*
import kotlinx.android.synthetic.main.payment_deatils_popup.*


class Pending_payments_recycler_Adapater(val paymentdata: ArrayList<UserData_payments>, val context: Context): RecyclerView.Adapter<Pending_payments_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pending_payments_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.user_screen , parent , false)
        return Pending_payments_viewholder(view)
    }

    override fun onBindViewHolder(holder: Pending_payments_viewholder, position: Int) {
       //holder.profile_image.setImageResource(profile_image[position])
        holder.patient_name.text= paymentdata[position].user.first_name + "" + paymentdata[position].user.last_name
        holder.time.text = CommonFunction.dateFormat(paymentdata[position].user.created_at)
        holder.itemView.setOnClickListener{
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_dialuge)
            dialog.setContentView(R.layout.payment_deatils_popup)
            dialog.name_popup.text =  paymentdata[position].user.first_name + "" + paymentdata[position].user.last_name
            dialog.time_date_popup1.text = CommonFunction.dateFormat(paymentdata[position].user.created_at)
            dialog.session_purchased1.text = paymentdata[position].number_of_sessions.toString()
            dialog.session_total_payment.text = paymentdata[position].cost.toString()



            Glide.with(context)
                .load(paymentdata[position].picture)
                .centerCrop()
                .into(dialog.reciept)

            dialog.reject_button.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
            dialog.accept_button.setOnClickListener {
                dialog.dismiss()
            }



        }
    }

    override fun getItemCount(): Int {
       return  paymentdata.size
    }
}
class Pending_payments_viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

    val profile_image = itemView.findViewById<ImageView>(com.example.pukaaradmin.R.id.profile_image)
    val patient_name =  itemView.findViewById<TextView>(com.example.pukaaradmin.R.id.profile_name)
    val time = itemView.findViewById<TextView>(com.example.pukaaradmin.R.id.time)

}