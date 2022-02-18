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
import com.example.pukaaradmin.Response.Sessions_LogResponse;
import com.example.pukaaradmin.apiinterface.ApiInterface;

import java.util.ArrayList;

public class SessionsummaryAdapter extends RecyclerView.Adapter<SessionsummaryViewholder> {
    private ArrayList<Sessions_LogResponse.FirstDatum> sessions_logResponses;
    private ApiInterface apiInterface;
    Context context1;
    private LayoutInflater mInflater;

    public SessionsummaryAdapter(Context context1, ArrayList<Sessions_LogResponse.FirstDatum> firstData) {
        this.mInflater = LayoutInflater.from(context1);
        apiInterface = ApiClient.Companion.create();
        this.sessions_logResponses = firstData;
        this.context1 = context1;

    }

    @NonNull
    @Override
    public SessionsummaryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.session_summarylayout, parent, false);
        return new SessionsummaryViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionsummaryViewholder holder, int position) {
        holder.therapist_name1.setText(sessions_logResponses.get(position).therapist.first_name + " " + sessions_logResponses.get(position).therapist.last_name);
        holder.time1.setText(sessions_logResponses.get(position).session_taken_time);
        holder.sessionTaken1.setText(sessions_logResponses.get(position).session_taken);

    }

    @Override
    public int getItemCount() {
        return sessions_logResponses.size();
    }
}

class SessionsummaryViewholder extends RecyclerView.ViewHolder {
    TextView therapist_name1, time1,sessionTaken1;


    public SessionsummaryViewholder(@NonNull View itemView) {
        super(itemView);
        therapist_name1 = itemView.findViewById(R.id.doc_name);
        time1 = itemView.findViewById(R.id.datetime);
        sessionTaken1 = itemView.findViewById(R.id.sessionTaken1);


    }
}