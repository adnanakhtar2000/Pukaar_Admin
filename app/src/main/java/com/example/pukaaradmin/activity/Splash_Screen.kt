package com.example.pukaaradmin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.Recycler_Adapters.Approved_payments_recycler_Adapater
import com.example.pukaaradmin.Response.ConnectUserResponse
import com.example.pukaaradmin.Response.UserSessionResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.ActivitySplashScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Splash_Screen : AppCompatActivity() {

    lateinit var splashScreenBinding: ActivitySplashScreenBinding
    private lateinit var apiInterface: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashScreenBinding.root)
        Handler().postDelayed({
            if(CommonFunction.getToken(applicationContext).length>10)
            {
                val intent = Intent(this, Dashboard::class.java);
                startActivity(intent);
                finish();
            }
            else {
                val intent = Intent(this, Login::class.java);
                startActivity(intent);
                finish();
            }
        }, 2000)

        apiInterface = ApiClient.create()
        val call = apiInterface.getConnectedUserResponse(CommonFunction.getToken(applicationContext),"2")
        call.enqueue(object : Callback<ConnectUserResponse> {
            override fun onResponse(
                call: Call<ConnectUserResponse>?,
                response: Response<ConnectUserResponse>?
            ) {
                if (response?.body() != null) {
                    if(applicationContext!= null) {
                       // response.body()!!.user.therapist_profile.client       // pass this list to adapter
                       // response.body()!!.user.therapist_profile.client.get(position).user.first_name   // pass in adapter class for showing data

                    }
                    //setting data
                }
            }

            override fun onFailure(call: Call<ConnectUserResponse>?, t: Throwable?) {

            }
        })
    }
}