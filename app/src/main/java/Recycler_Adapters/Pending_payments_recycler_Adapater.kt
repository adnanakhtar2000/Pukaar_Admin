package Recycler_Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.R

class Pending_payments_recycler_Adapater(val profile_image : List<Int> , val patient_name : List<String> , val time : List<String>): RecyclerView.Adapter<Pending_payments_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pending_payments_viewholder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.user_screen , parent , false)
        return Pending_payments_viewholder(view)
    }

    override fun onBindViewHolder(holder: Pending_payments_viewholder, position: Int) {
       holder.profile_image.setImageResource(profile_image[position])
        holder.patient_name.text= patient_name[position]
        holder.time.text = time[position]
    }

    override fun getItemCount(): Int {
       return  patient_name.size
    }
}
class Pending_payments_viewholder(itemView: View): RecyclerView.ViewHolder(itemView){

    val profile_image = itemView.findViewById<ImageView>(R.id.profile_image)
    val patient_name =  itemView.findViewById<TextView>(R.id.profile_name)
    val time = itemView.findViewById<TextView>(R.id.time)

}