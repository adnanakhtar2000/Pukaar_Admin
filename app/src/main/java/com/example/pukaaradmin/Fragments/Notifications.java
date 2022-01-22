package com.example.pukaaradmin.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pukaaradmin.ApiClient.ApiClient;
import com.example.pukaaradmin.CommonFunction;
import com.example.pukaaradmin.R;
import com.example.pukaaradmin.Recycler_Adapters.Notification_Adapter;
import com.example.pukaaradmin.Response.NotificationResponse;
import com.example.pukaaradmin.apiinterface.ApiInterface;
import com.example.pukaaradmin.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Notifications extends Fragment {
    FragmentNotificationsBinding notificationsBinding;
    private ApiInterface apiInterface;
    public Notification_Adapter notification_adapter;
    public NotificationResponse notificationResponse;



    public Notifications() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Notifications newInstance(String param1, String param2) {
        Notifications fragment = new Notifications();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        notificationsBinding = FragmentNotificationsBinding.inflate(inflater , container , false);

        apiInterface = ApiClient.Companion.create();
        Call<ArrayList<NotificationResponse>> call = apiInterface.getNotification(CommonFunction.Companion.getToken(requireContext()));
        call.enqueue(new Callback<ArrayList<NotificationResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<NotificationResponse>> call, Response<ArrayList<NotificationResponse>> response) {

if (response.body() != null){
                notification_adapter = new Notification_Adapter(requireContext(),response.body() );
                //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                LinearLayoutManager llm = new LinearLayoutManager(requireContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
             notificationsBinding.notificationRecycler.setLayoutManager(llm);
                notificationsBinding.notificationRecycler.setAdapter(notification_adapter);}
            }

            @Override
            public void onFailure(Call<ArrayList<NotificationResponse>> call, Throwable t) {
            }
        });
        return notificationsBinding.getRoot();
    }
}