package com.example.pukaaradmin.Recycler_Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.TherapistListResponse
import com.example.pukaaradmin.Response.UsersData

class Availble_Therapist_recycler_Adapater(val data: ArrayList<UsersData>) : RecyclerView.Adapter<Availble_Therapist_recycler_Adapater.Availble_Therapist_viewholder>() {


private  lateinit var itemClickListener : ItemClickListener
private lateinit var therapis_response : List<TherapistListResponse>

   /* private List<DiaryResponse.FirstDatum.Datum> diaryResponseData;*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Availble_Therapist_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.user_screen , parent , false)
        return Availble_Therapist_viewholder(view)
    }

    override fun onBindViewHolder(holder: Availble_Therapist_viewholder, position: Int) {
       //holder.profile_image.setImageResource(profile_image[position])
        holder.patient_name.text = data[position].first_name +" " +data[position].last_name
        holder.time.text = CommonFunction.dateFormat(data[position].created_at)
    }

    override fun getItemCount(): Int {
       return  data.size
    }

    class Availble_Therapist_viewholder(itemView: View): RecyclerView.ViewHolder(itemView) , View.OnClickListener{

        val profile_image = itemView.findViewById<ImageView>(R.id.profile_image)
        val patient_name =  itemView.findViewById<TextView>(R.id.profile_name)
        val time = itemView.findViewById<TextView>(R.id.time)
        override fun onClick(v: View?) {

        }

    }
    public interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener

    }
}
