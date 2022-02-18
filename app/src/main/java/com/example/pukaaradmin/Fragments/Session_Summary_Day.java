package com.example.pukaaradmin.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pukaaradmin.ApiClient.ApiClient;
import com.example.pukaaradmin.CommonFunction;
import com.example.pukaaradmin.R;
import com.example.pukaaradmin.Recycler_Adapters.SessionsummaryAdapter;
import com.example.pukaaradmin.Response.Sessions_LogResponse;
import com.example.pukaaradmin.apiinterface.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Session_Summary_Day extends Fragment {
    ApiInterface apiInterface;



    public Session_Summary_Day() {
        // Required empty public constructor
    }


    public static Session_Summary_Day newInstance(String param1, String param2) {
        Session_Summary_Day fragment = new Session_Summary_Day();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_session__summary__day, container, false);
        ProgressDialog progressDialog = new ProgressDialog(requireContext());
        progressDialog.setMessage("please wait Data is Fetching...");
        progressDialog.setTitle("Data Fetching");
        progressDialog.setCancelable(false);
        progressDialog.show();

        apiInterface = ApiClient.Companion.create();
        Call<Sessions_LogResponse> call = apiInterface.SessionsLogs(CommonFunction.Companion.getToken(requireContext()));
        call.enqueue(new Callback<Sessions_LogResponse>() {
            @Override
            public void onResponse(Call<Sessions_LogResponse> call, Response<Sessions_LogResponse> response) {
                if (response.body() != null){
                    SessionsummaryAdapter sessionsList_adapter = new SessionsummaryAdapter(requireContext(), response.body().Fdata);
                    //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    LinearLayoutManager llm = new LinearLayoutManager(requireContext());
                    RecyclerView   recyclerView = view.findViewById(R.id.diaryRecyclerViewDay);
                    llm.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(llm);
                    recyclerView.setAdapter(sessionsList_adapter);
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<Sessions_LogResponse> call, Throwable t) {

            }
        });

        return view;
    }
}