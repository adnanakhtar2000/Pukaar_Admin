package com.example.pukaaradmin.Recycler_Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pukaaradmin.ApiClient.ApiClient;
import com.example.pukaaradmin.R;
import com.example.pukaaradmin.Response.NotificationResponse;
import com.example.pukaaradmin.apiinterface.ApiInterface;

import java.util.ArrayList;

public class Notification_Adapter extends RecyclerView.Adapter<notification_viewholder>{
    private ArrayList<NotificationResponse> notificationresponce;
    private ApiInterface apiInterface;
    Context context1;
    private LayoutInflater mInflater;

    public Notification_Adapter(Context context1, ArrayList<NotificationResponse> notificationresponce){
        this.mInflater = LayoutInflater.from(context1);
        apiInterface = ApiClient.Companion.create();
        this.notificationresponce = notificationresponce;
        this.context1 = context1;
    }

    @NonNull
    @Override
    public notification_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.notification_layout, parent, false);
        return new notification_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull notification_viewholder holder, int position) {
        holder.textview1.setText(notificationresponce.get(position).sender.first_name  + " " + notificationresponce.get(position).sender.last_name );
        holder.data1.setText(notificationresponce.get(position).data);

    }

    @Override
    public int getItemCount() {
        return notificationresponce.size();
    }
}

class notification_viewholder extends RecyclerView.ViewHolder {
    TextView  textview1 , data1;


    public notification_viewholder(@NonNull View itemView) {
        super(itemView);
        textview1 = itemView.findViewById(R.id.textView1);
        data1    = itemView.findViewById(R.id.data1);


    }
}
