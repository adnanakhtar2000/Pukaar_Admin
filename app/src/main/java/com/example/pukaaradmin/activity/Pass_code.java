package com.example.pukaaradmin.activity;

import android.app.Notification;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.pukaaradmin.ApiClient.ApiClient;
import com.example.pukaaradmin.CommonFunction;
import com.example.pukaaradmin.R;
import com.example.pukaaradmin.Response.PasscodeResponse;
import com.example.pukaaradmin.apiinterface.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

import in.aabhasjindal.otptextview.OtpTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pass_code extends AppCompatActivity {
    @BindView(R.id.back_arrow_22)
    ImageView back_arrow_22;
  @BindView(R.id.verify_button)
  Button verify_button;
  @BindView(R.id.otp_view1)
  OtpTextView otp_view1;
    private ApiInterface apiInterface;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_code);
        ButterKnife.bind(this);
        Window window  = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            window.setStatusBarColor(getResources().getColor(R.color.text_blue));
        }
        apiInterface = ApiClient.Companion.create();
        ImageView bell =findViewById(R.id.pc_bell);
        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pass_code.this , Dashboard.class);
                startActivity(intent);
            }
        });
        back_arrow_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Pass_code.this,Dashboard.class));
                overridePendingTransition(0,0);
            }
        });
        verify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(Pass_code.this);
                progressDialog.setMessage("Please wait Passcode is Setting...");
                progressDialog.setTitle("Passcode");
                progressDialog.setCancelable(false);
                progressDialog.show();

                Call<PasscodeResponse> call = apiInterface.passcode_call(CommonFunction.Companion.getToken(getApplicationContext()),otp_view1.getOtp().toString() , otp_view1.getOtp().toString() );
              call.enqueue(new Callback<PasscodeResponse>() {
                  @Override
                  public void onResponse(Call<PasscodeResponse> call, Response<PasscodeResponse> response) {
                      if (response.body() != null){
                          progressDialog.dismiss();
                          Toast.makeText(Pass_code.this,  "Passcode Set Successfully", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(Pass_code.this,Dashboard.class));
                          overridePendingTransition(0,0);
                      }
                      else {
                          progressDialog.dismiss();
                          Toast.makeText(Pass_code.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                      }
                  }

                  @Override
                  public void onFailure(Call<PasscodeResponse> call, Throwable t) {
                      progressDialog.dismiss();
                      Toast.makeText(Pass_code.this,  t.getMessage(), Toast.LENGTH_SHORT).show();



                  }
              });
            }
        });
    }
}