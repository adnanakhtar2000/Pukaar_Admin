package com.example.pukaaradmin.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.pukaaradmin.ApiClient.ApiClient;
import com.example.pukaaradmin.CommonFunction;
import com.example.pukaaradmin.R;
import com.example.pukaaradmin.Response.ForumResponse;
import com.example.pukaaradmin.apiinterface.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Forum_Adapter extends RecyclerView.Adapter<forum_viewholder> {
    private ArrayList<ForumResponse.FirstDatum> Forumresponce;
    private ApiInterface apiInterface;
    Context context1;
    private LayoutInflater mInflater;

    public Forum_Adapter(Context applicationContext, ArrayList<ForumResponse.FirstDatum> fdata) {
        this.mInflater = LayoutInflater.from(applicationContext);
        apiInterface = ApiClient.Companion.create();
        Forumresponce = fdata;
        context1 = applicationContext;
    }

    @NonNull
    @Override
    public forum_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_forum, parent, false);
        return new forum_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull forum_viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.forum_name.setText(Forumresponce.get(position).userData.first_name + " " + Forumresponce.get(position).userData.last_name );
        holder.forum_time.setText(Forumresponce.get(position).createdAt );
       /* holder.forum_post_pic.setImageResource(Integer.parseInt(Forumresponce.get(position).Fdata.get(position).picture));*/
        Glide.with(context1)
                .load("https://pukar.qareeb.com" + Forumresponce.get(position).picture)
                .centerCrop()
                .into(holder.forum_post_pic);
        holder.send_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.editText.getText().toString().trim().length()>0)
                {
                Call<String> call = apiInterface.createComment(CommonFunction.Companion.getToken(context1),holder.editText.getText().toString() ,Forumresponce.get(position).id);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.body() != null) {
                            if (response.body().toString().toLowerCase().equalsIgnoreCase("Success")) {
//                                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                                //finish();
                                holder.editText.setText("");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
                else
                        Toast.makeText(context1,"Enter Any Comment",Toast.LENGTH_SHORT).show();
        }

    });

        holder.forum_post_text.setText(Forumresponce.get(position).content);

    }

    @Override
    public int getItemCount() {
        return Forumresponce.size();
    }
}

class forum_viewholder extends RecyclerView.ViewHolder {
    TextView forum_name , forum_time , forum_post_text, send_comment;
    ImageView forum_post_pic , forum_profile;
    EditText editText;

    public forum_viewholder(@NonNull View itemView) {
        super(itemView);

        forum_name = itemView.findViewById(R.id.forum_name);
        forum_time    = itemView.findViewById(R.id.forum_time);
        forum_post_text =itemView.findViewById(R.id.forum_post_text);
        forum_profile = itemView.findViewById(R.id.forum_profile);
        forum_post_pic = itemView.findViewById(R.id.forum_post_pic);
        editText = itemView.findViewById(R.id.editText);
        send_comment = itemView.findViewById(R.id.send_comment);
    }
}


