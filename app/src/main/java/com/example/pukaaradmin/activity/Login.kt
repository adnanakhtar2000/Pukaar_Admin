package com.example.pukaaradmin.activity

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.CommonFunction
import com.example.pukaaradmin.Response.LoginResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding= ActivityLoginBinding.inflate(layoutInflater)
         apiInterface = ApiClient.create()

        setContentView(loginBinding.root)
        loginBinding.loginScreenButton.setOnClickListener {
            if (email_validation() && password_validation()){
                val progressDialog = ProgressDialog(this)
                progressDialog.setMessage("Please wait Data is Fetching...")
                progressDialog.setTitle("Data Fetching")
                progressDialog.setCancelable(false)
                progressDialog.show()

                val loginResponse = apiInterface.getLoginResponse(loginBinding.mainEmail.text.toString(),loginBinding.mainPassword.text.toString())
                loginResponse.enqueue( object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {

                        if(response?.body() != null)
                        {

progressDialog.dismiss()
                            CommonFunction.saveToken(applicationContext, response.body()!!.data.token)
                            CommonFunction.saveName(applicationContext, response.body()!!.data.first_name+" "+response.body()!!.data.last_name)
                            CommonFunction.saveUserId(applicationContext, response.body()!!.data.user_id.toString())

                            //overridePendingTransition(0,0)

                            var isAdmin : Boolean = false
                            for (item :String in response.body()!!.data.role)
                            {
                                if(item == "admin")
                                    isAdmin = true
                            }
                            if(isAdmin) {
                                CommonFunction.saveToken(
                                    applicationContext,
                                    response.body()!!.data.token
                                )
                                CommonFunction.saveName(
                                    applicationContext,
                                    response.body()!!.data.first_name + " " + response.body()!!.data.last_name
                                )
                                val intent = Intent(applicationContext, Dashboard::class.java)
                                startActivity(intent)
                                finish()
                                overridePendingTransition(0, 0)
                            }else {
                                if(response.body()!!.data.role.isEmpty())
                                {
                                    val intent = Intent(applicationContext, Dashboard::class.java)
                                    startActivity(intent)
                                    finish()
                                    overridePendingTransition(0, 0)
                                }
                                Toast.makeText(
                                    applicationContext,
                                    "Please Enter Admin Email and Password...",
                                    Toast.LENGTH_LONG
                                ).show();
                            }

                        }
                        else
                            progressDialog.dismiss()
                             }
//admin panel
                    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {

                    }
                })
               /**/
            }
        }
    }

    private  fun email_validation() : Boolean{
        val email_validation = loginBinding.mainEmail.text.toString()

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        if (email_validation.isEmpty() ){
            loginBinding.mainEmail.setError("Email filed cannot be empty")
            return false
        }
        if (!email_validation.matches(emailPattern.toRegex()) ){
            loginBinding.mainEmail.setError("Email Adress in invalid")
            return false
        }
        else return true
    }

    private  fun password_validation(): Boolean{
        val password_validation = loginBinding.mainPassword.text.toString().trim()
        if (password_validation.isEmpty() ){
            loginBinding.mainPassword.setError("Password must be Entered")
            return false
        }
        else{
            return true
        }
    }
}