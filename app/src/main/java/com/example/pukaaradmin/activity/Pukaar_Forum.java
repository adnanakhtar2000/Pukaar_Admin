package com.example.pukaaradmin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pukaaradmin.Adapters.Forum_Adapter;
import com.example.pukaaradmin.ApiClient.ApiClient;
import com.example.pukaaradmin.CommonFunction;
import com.example.pukaaradmin.R;
import com.example.pukaaradmin.Response.ForumResponse;
import com.example.pukaaradmin.apiinterface.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pukaar_Forum extends AppCompatActivity {
    private ApiInterface apiInterface;
    public Forum_Adapter forum_adapter;
    public ForumResponse forumResponse;
    RecyclerView recyclerView;
    Button create_post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pukaar_forum);
        recyclerView = findViewById(R.id.forum_recycler);
        create_post = findViewById(R.id.create_post_button);
        apiInterface = ApiClient.Companion.create();
        Call<ForumResponse> call = apiInterface.getForumList(CommonFunction.Companion.getToken(getApplicationContext()));
        call.enqueue(new Callback<ForumResponse>() {
            @Override
            public void onResponse(Call<ForumResponse> call, Response<ForumResponse> response) {
                if (response.body() !=null) {
                    forum_adapter = new Forum_Adapter(getApplicationContext(), response.body().Fdata);
                    //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    LinearLayoutManager llm = new LinearLayoutManager(Pukaar_Forum.this);
                    llm.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(llm);
                    recyclerView.setAdapter(forum_adapter);
                }
                else {

                    Toast.makeText(getApplicationContext() ,  response.body().toString(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ForumResponse> call, Throwable t) {

            }
        });
 create_post.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent  intent= new Intent(Pukaar_Forum.this , My_Post.class);
         startActivity(intent);
     }
 });
    }
}