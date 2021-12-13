package com.example.pukaaradmin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.R
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.ActivityAddBankDetailBinding
import com.example.pukaaradmin.databinding.ActivityAddTherapistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Add_Bank_Detail : AppCompatActivity() {
    private  lateinit var  addBankDetailBinding: ActivityAddBankDetailBinding
    private lateinit var apiInterface: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addBankDetailBinding = ActivityAddBankDetailBinding.inflate(layoutInflater)
        setContentView(addBankDetailBinding.root)
        apiInterface = ApiClient.create()

        addBankDetailBinding.addBankButton.setOnClickListener {
            if(validation())
            {
                val call = apiInterface.createBankDetail(CommonFunction.getToken(applicationContext),addBankDetailBinding.bankName.text.toString(),addBankDetailBinding.BranchName.text.toString(),addBankDetailBinding.accountNumber.text.toString(),addBankDetailBinding.accountTitle.text.toString(),addBankDetailBinding.accountIban.text.toString())
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
    }
    private  fun validation() : Boolean{
        val bankName = addBankDetailBinding.bankName.text.toString()
        val branchName = addBankDetailBinding.BranchName.text.toString()
        val accNumber = addBankDetailBinding.accountNumber.text.toString()
        val accTitle= addBankDetailBinding.accountTitle.text.toString()
        val iban= addBankDetailBinding.accountIban.text.toString()


         if (bankName.isEmpty() ){
            addBankDetailBinding.bankName.setError("Please Enter Bank Name")
            false
        }
        if (branchName.isEmpty() ){
            addBankDetailBinding.BranchName.setError("Please Enter Branch Name")
            false
        }
          if (accNumber.isEmpty() ){
            addBankDetailBinding.accountNumber.setError("Please Enter Account Number")
            false
        }
        if (accTitle.isEmpty() ){
            addBankDetailBinding.accountTitle.setError("Please Enter Account Title")
            false
        }
         if (iban.isEmpty() ){
            addBankDetailBinding.accountIban.setError("Please Enter IBAN Number")
            false
        }

        return true
    }

}