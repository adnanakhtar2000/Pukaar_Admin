package com.example.pukaaradmin.Recycler_Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.Fragments.DailyDiaryData
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.*


class Daily_Diary_Adapter(val dailydairyresponse: DailyDiaryData, val context: Context): RecyclerView.Adapter<Daily_Diary_View>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Daily_Diary_View {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.diary_recyler_view, parent, false)
        return Daily_Diary_View(view)
    }

    override fun onBindViewHolder(holder: Daily_Diary_View, position: Int) {
        //   holder.profile_image.setImageResource(profile_image[position])
        holder.timeTextView.text =
            CommonFunction.dateFormat(dailydairyresponse.data[position].created_at)
        holder.titleTextView.text = dailydairyresponse.data[position].mood
        holder.dateTextView.text =
            CommonFunction.dateFormat(dailydairyresponse.data[position].created_at)
        if (dailydairyresponse.data[position].toString().toLowerCase().contains("Hello" , true)
        ) {
            holder.mood_emoji.setImageResource(R.drawable.crying)
        } else if (dailydairyresponse.data[position].toString().toLowerCase()
                .contains("Depressed", ignoreCase = true)
        ) {
            holder.mood_emoji.setImageResource(R.drawable.depressed)
        } else if (dailydairyresponse.toString().toLowerCase()
                .contains("Excited" , ignoreCase = true)

        ) {
            holder.mood_emoji.setImageResource(R.drawable.excited)
        } else if (dailydairyresponse.data[position].toString().toLowerCase()
                .contains("OK" ,ignoreCase = true)

        ) {
            holder.mood_emoji.setImageResource(R.drawable.ok)
        } else if (dailydairyresponse.data[position].toString().toLowerCase()
                .contains("Sad", ignoreCase = true)

        ) {
            holder.mood_emoji.setImageResource(R.drawable.sad)
        } else {
            holder.mood_emoji.setImageResource(R.drawable.ic_bad)
        }


    }

    override fun getItemCount(): Int {
        return  dailydairyresponse.data.size
    }
}
class Daily_Diary_View(itemView: View): RecyclerView.ViewHolder(itemView){

    val mood_emoji = itemView.findViewById<ImageView>(R.id.mood_emoji)
    val timeTextView =  itemView.findViewById<TextView>(R.id.timeTextView)
    val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
    val dateTextView = itemView.findViewById<TextView>(R.id.dateTextView)

}