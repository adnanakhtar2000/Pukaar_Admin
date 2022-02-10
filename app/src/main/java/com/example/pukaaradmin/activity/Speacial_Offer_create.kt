package com.example.pukaaradmin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.LoginResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.ActivitySpeacialOfferCreateBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Speacial_Offer_create : AppCompatActivity() {

    private lateinit var speacialOfferCreateBinding: ActivitySpeacialOfferCreateBinding
    private lateinit var apiInterface: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        speacialOfferCreateBinding = ActivitySpeacialOfferCreateBinding.inflate(layoutInflater)
        apiInterface = ApiClient.create()
        setContentView(speacialOfferCreateBinding.root)

        speacialOfferCreateBinding.addOfferButton.setOnClickListener {
            if(sessionValidation() && priceValidation()) {
                val call =
                    apiInterface.createSpecialOffer(CommonFunction.getToken(applicationContext),speacialOfferCreateBinding.sessionEditText.text.toString().toInt(),speacialOfferCreateBinding.priceEditText.text.toString())
                call.enqueue(object : Callback<String> {
                    override fun onResponse(
                        call: Call<String>?,
                        response: Response<String>?
                    ) {
                        if (response?.body() != null) {
                            if(response.body().equals("success"))
                                finish()
                        }
                    }

                    override fun onFailure(call: Call<String>?, t: Throwable?) {

                    }
                })
            }
        }

        speacialOfferCreateBinding.backArrow.setOnClickListener {
            finish()
        }
    }
    private  fun sessionValidation() : Boolean{
        val sessionValue = speacialOfferCreateBinding.sessionEditText.text.toString()


        return if (sessionValue.isEmpty() ){
            speacialOfferCreateBinding.sessionEditText.setError("Please Enter Session Number")
            false
        } else true
    }

    private  fun priceValidation(): Boolean{
        val price = speacialOfferCreateBinding.priceEditText.text.toString().trim()
        if (price.isEmpty() ){
            speacialOfferCreateBinding.priceEditText.setError("Please Enter Session Price")
            return false
        }
        else{
            return true
        }
    }
}