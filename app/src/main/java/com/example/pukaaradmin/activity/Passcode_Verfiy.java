package com.example.pukaaradmin.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
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

public class Passcode_Verfiy extends AppCompatActivity {

    @BindView(R.id.verify_button1)
    Button verify_button;
    @BindView(R.id.otp_view11)
    OtpTextView otp_view1;
    private ApiInterface apiInterface;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode_verfiy);
        ButterKnife.bind(this);
        Window window  = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            window.setStatusBarColor(getResources().getColor(R.color.text_blue));
        }
        apiInterface = ApiClient.Companion.create();
        verify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(Passcode_Verfiy.this);
                progressDialog.setMessage("Please wait Passcode is Checking...");
                progressDialog.setTitle("Passcode");
                progressDialog.setCancelable(false);
                progressDialog.show();

                Call<PasscodeResponse> call = apiInterface.passcode_verify(CommonFunction.Companion.getToken(getApplicationContext()),otp_view1.getOtp().toString() );
                call.enqueue(new Callback<PasscodeResponse>() {
                    @Override
                    public void onResponse(Call<PasscodeResponse> call, Response<PasscodeResponse> response) {
                        if (response.body() != null){
                            progressDialog.dismiss();
                            Toast.makeText(Passcode_Verfiy.this,  "Passcode Matched", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Passcode_Verfiy.this,Dashboard.class));
                            overridePendingTransition(0,0);
                        }
                        else {
                            progressDialog.dismiss();
                            Toast.makeText(Passcode_Verfiy.this, "Passcode Not Matched", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PasscodeResponse> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(Passcode_Verfiy.this,  t.getMessage(), Toast.LENGTH_SHORT).show();



                    }
                });
            }
        });
    }
}