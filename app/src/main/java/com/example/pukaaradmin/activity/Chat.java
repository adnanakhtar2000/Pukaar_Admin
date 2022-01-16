package com.example.pukaaradmin.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pukaaradmin.Adapters.MessageListAdapter;
import com.example.pukaaradmin.ApiClient.ApiClient;
import com.example.pukaaradmin.CommonFunction;
import com.example.pukaaradmin.R;
import com.example.pukaaradmin.Response.MessageResponse;
import com.example.pukaaradmin.apiinterface.ApiInterface;
import com.google.gson.Gson;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Chat extends AppCompatActivity {

    private EditText editText;
    private TextView send;
    private ApiInterface apiInterface;
    ArrayList<MessageResponse.FirstDatum> messageList = new ArrayList<>();
    private Socket mSocket;
    private MessageListAdapter mMessageAdapter;
    private RecyclerView mMessageRecycler;
    private String id = "3";
    public void setId(String id)
    {
      this.id = id;
    }

    {
        try {
            mSocket = IO.socket("http://pukar.qareeb.com/api");
        } catch (URISyntaxException e) {
            Log.d("myTag", e.getMessage());
            //e.getMessage();
        }
    }

    private void connectToSignallingServer() {
        try {
            String URL = "http://185.206.135.170:8005";
            mSocket = IO.socket(URL);

            mSocket.on("connect", args -> {
                Log.d("hello", "connectToSignallingServer: connect");
                mSocket.emit("user_connected", CommonFunction.Companion.getUserId(getApplicationContext()));
                //mSocket.emit("user_connected", 3);
            });
            mSocket.on("private-channel:App\\Events\\PrivateMessageEvent",onNewMessage);
            mSocket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Gson gson = new Gson();
                    MessageResponse.FirstDatum response = gson.fromJson(args[0].toString(), MessageResponse.FirstDatum.class);
                    messageList.add(response);
                    mMessageAdapter.notifyDataSetChanged();
                    mMessageRecycler.scrollToPosition(mMessageRecycler.getAdapter().getItemCount() - 1);
                }
            });
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //id = getIntent().getExtras().getString("id");
        connectToSignallingServer();
        editText = findViewById(R.id.editText);
        send = findViewById(R.id.send_comment);
        mMessageRecycler = findViewById(R.id.chat_recycler);
        apiInterface = ApiClient.Companion.create();
        mMessageAdapter = new MessageListAdapter(this, messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(mMessageAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().trim().length()>0)
                {
                    Call<MessageResponse> call = apiInterface.sendMessage(CommonFunction.Companion.getToken(getApplicationContext()),id,editText.getText().toString());
                    call.enqueue(new Callback<MessageResponse>() {
                        @Override
                        public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                            if (response.body() != null) {
                                if (response.body().getFdata()!= null) {
                                    messageList.add(response.body().getFdata());
                                    editText.setText("");
                                    mMessageAdapter.notifyDataSetChanged();
                                    mMessageRecycler.scrollToPosition(mMessageRecycler.getAdapter().getItemCount() - 1);

                                    //message list add into adapter class and show message
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<MessageResponse> call, Throwable t) {
                        }
                    });
                }
            }
        });
    }
}