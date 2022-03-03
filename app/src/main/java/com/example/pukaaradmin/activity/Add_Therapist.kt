package com.example.pukaaradmin.activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.pukaaradmin.ApiClient.ApiClient
import com.example.pukaaradmin.R
import com.example.pukaaradmin.Response.SignUpResponse
import com.example.pukaaradmin.apiinterface.ApiInterface
import com.example.pukaaradmin.databinding.ActivityAddTherapistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Add_Therapist : AppCompatActivity() {

    private  lateinit var addTherapistBinding: ActivityAddTherapistBinding
    private lateinit var apiInterface: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addTherapistBinding=ActivityAddTherapistBinding.inflate(layoutInflater)
        setContentView(addTherapistBinding.root)
        apiInterface = ApiClient.create()
        addTherapistBinding.backArrow.setOnClickListener {
            finish()
        }

        addTherapistBinding.typeDoctor1.setRawInputType(InputType.TYPE_NULL)
        addTherapistBinding.service1.setRawInputType(InputType.TYPE_NULL)
        val provinces = resources.getStringArray(R.array.Doctor_Type)
        val padapter = ArrayAdapter(this,  R.layout.spinner_dropdown_itemlist, provinces)
        addTherapistBinding.typeDoctor1.setAdapter(padapter)

        val Doctor_services = resources.getStringArray(R.array.Doctor_services)
        val padapter1 = ArrayAdapter(this,  R.layout.spinner_dropdown_itemlist, Doctor_services)
        addTherapistBinding.service1.setAdapter(padapter1)



        addTherapistBinding.addDoctorsButton1.setOnClickListener {
            val progressDialog = ProgressDialog(applicationContext)
            progressDialog.setMessage("Please wait Data is Fetching...")
            progressDialog.setTitle("Data Fetching")
            progressDialog.setCancelable(false)
            progressDialog.show()

            if (namevalidation() && about_validaiton() && mobile_number_validation() && passwordValidation() && email_validation() && cityvalidation() && servicevalidation() && therapist_focus() && type_of_doctor()){

                /*val intent = Intent(this , Added_Therapist::class.java)
                startActivity(intent)
                overridePendingTransition(0,0)*/
                var statusValue : Int = 1
                val status = addTherapistBinding.activeSwitch.isChecked
                statusValue = if(status)
                    1
                else
                    2

                val signUpResponse = apiInterface.getRegisterResponse(addTherapistBinding.firstName1.text.toString(),addTherapistBinding.lastNameEditTet.text.toString(),
                    addTherapistBinding.email1.text.toString(),addTherapistBinding.mobileNumber1.text.toString(),addTherapistBinding.passwordEditText.text.toString(),addTherapistBinding.passwordEditText.text.toString(),"therapist",addTherapistBinding.about1.text.toString(),addTherapistBinding.city1.text.toString(),addTherapistBinding.service1.text.toString(),addTherapistBinding.therapist1.text.toString(),addTherapistBinding.typeDoctor1.text.toString(),statusValue, addTherapistBinding.introduction1.text.toString(), addTherapistBinding.education1.text.toString())
                signUpResponse.enqueue( object : Callback<SignUpResponse> {
                    override fun onResponse(call: Call<SignUpResponse>?, response: Response<SignUpResponse>?) {

                        if(response?.body() != null)
                        {
                            progressDialog.dismiss()
                            //CommonFunction.saveToken(applicationContext, response.body()!!.data.token)
                            //CommonFunction.saveName(applicationContext, response.body()!!.data.first_name+" "+response.body()!!.data.last_name)
                            val intent = Intent(applicationContext , Dashboard::class.java)
                            startActivity(intent)
                            overridePendingTransition(0,0)
                            finish()
                        }
                        else
                            progressDialog.dismiss()
                            Toast.makeText(applicationContext, "Please Enter All Fields Correctly",
                                Toast.LENGTH_LONG).show();
                    }

                    override fun onFailure(call: Call<SignUpResponse>?, t: Throwable?) {
                        progressDialog.dismiss()
                        Toast.makeText(applicationContext,"Error...",
                            Toast.LENGTH_LONG).show();
                    }
                })
            }
        }


    }

    private fun passwordValidation(): Boolean {
        val password =  addTherapistBinding.passwordEditText.text.toString().trim()
        if (password.isEmpty() || password.length<6){
            addTherapistBinding.passwordEditText.setError("Mobile Number field must contain 7 number")
            return false

        }
        return true;
    }

    // Name Validations
    private fun namevalidation() : Boolean {
        val name = addTherapistBinding.firstName1.text.toString().trim()
        val lastName = addTherapistBinding.lastNameEditTet.text.toString().trim()
        val about = addTherapistBinding.about1.text.toString().trim()
        val mobile_number = addTherapistBinding.mobileNumber1.text.toString().trim()

        if (name.isEmpty()){
            addTherapistBinding.firstName1.error = "First Name Field Cannot be Empty"
            return false
        }
        if (lastName.isEmpty()){
            addTherapistBinding.lastName.error = "Last Name Field Cannot be Empty"
            return false
        }
        else{
            return true
        }}
    // About Validation
    private fun about_validaiton() : Boolean {

        val about = addTherapistBinding.about1.text.toString().trim()


        if (about.isEmpty()) {
            addTherapistBinding.about1.setError("About Field Cannot be Empty")
            return false
        } else {
            return true
        }
    }
//Mobile Number Validation

    private fun mobile_number_validation() : Boolean{
        val mobile_number =  addTherapistBinding.mobileNumber1.text.toString().trim()
        if (mobile_number.isEmpty() ){
            addTherapistBinding.mobileNumber1.setError("Mobile Number field must contain 11 number")
            return false

        }
        if (mobile_number.length<11 ){
            addTherapistBinding.mobileNumber1.setError("Mobile Number is Invalid")
            return false
        }
        else return true

    }

    //Email Validations
    private  fun email_validation() : Boolean{
        val email_validation = addTherapistBinding.email1.text.toString()

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        if (email_validation.isEmpty() ){
            addTherapistBinding.email1.setError("Email filed cannot be empty")
            return false
        }
        if (!email_validation.matches(emailPattern.toRegex()) ){
            addTherapistBinding.email1.setError("Email Adress in invalid")
            return false
        }
        else return true
    }
    // city Validations
    private fun cityvalidation() : Boolean {
        val city = addTherapistBinding.city1.text.toString().trim()

        if (city.isEmpty()){
            addTherapistBinding.city1.setError("Please Enter Your City Name")
            return false
        }
        else{
            return true
        }}
    // Service therapist Provide
    private fun servicevalidation() : Boolean {
        val service_therapist = addTherapistBinding.service1.text.toString().trim()

        if (service_therapist.isEmpty()){
            addTherapistBinding.service1.setError("Please Specify Your Services")
            return false
        }
        else{
            return true
        }}

    //Therapist Focus validations

    private fun therapist_focus() : Boolean {
        val therapist_focus = addTherapistBinding.therapist1.text.toString().trim()

        if (therapist_focus.isEmpty()){
            addTherapistBinding.therapist1.setError("Please set the Focus")
            return false
        }
        else{
            return true
        }}
    //Type of doctor Validation
    private fun type_of_doctor() : Boolean {
        val typeOf_therapist = addTherapistBinding.typeDoctor1.text.toString().trim()

        if (typeOf_therapist.isEmpty()){
            addTherapistBinding.typeDoctor1.setError("Please Enter Type of Doctor")
            return false
        }
        else{
            return true
        }}
}