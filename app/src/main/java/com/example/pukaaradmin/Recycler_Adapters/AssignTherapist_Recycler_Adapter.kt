package com.example.pukaaradmin.Recycler_Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.Fragments.Availble_Therapist
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.UsersData
import com.example.pukaaradmin.apiinterface.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AssignTherapist_Recycler_Adapter(val data : ArrayList<UsersData> , val context: Context): RecyclerView.Adapter<AssignTherapist_Recycler_viewholder>() {
    private lateinit var apiInterface: ApiInterface


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignTherapist_Recycler_viewholder {
        apiInterface = ApiClient.create()
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.user_screen , parent , false)
        return AssignTherapist_Recycler_viewholder(view)
    }

    override fun onBindViewHolder(holder: AssignTherapist_Recycler_viewholder, position: Int) {
        holder.patient_name.text = data[position].first_name +" " +data[position].last_name
        holder.time.text = CommonFunction.dateFormat(data[position].created_at)
        holder.itemView.setOnClickListener{

            val therapistResponse = apiInterface.assignedTherapist(CommonFunction.getToken(context),12 ,2)
            therapistResponse?.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Toast.makeText(context, "success", Toast.LENGTH_SHORT).show()
                    val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                    transaction.remove(Availble_Therapist())
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                }
            })

//            var therapist_Profile = Therapist_Profile()
//
//            val bundle = Bundle()
//            bundle.putParcelable("dataobject" , data.get(position))
//            therapist_Profile.arguments = bundle
//
//
//
//
//            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.container, therapist_Profile )
//            transaction.disallowAddToBackStack()
//            transaction.commit()
        }

    }

    override fun getItemCount(): Int {
       return  data.size
    }
}
class AssignTherapist_Recycler_viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

    val profile_image = itemView.findViewById<ImageView>(R.id.profile_image)
    val patient_name =  itemView.findViewById<TextView>(R.id.profile_name)
    val time = itemView.findViewById<TextView>(R.id.time)

}