package com.example.pukaaradmin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pukaaradmin.databinding.ActivityAddTherapistBinding

class Add_Therapist : AppCompatActivity() {

    private  lateinit var addTherapistBinding: ActivityAddTherapistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addTherapistBinding=ActivityAddTherapistBinding.inflate(layoutInflater)
        setContentView(addTherapistBinding.root)

        addTherapistBinding.addDoctorsButton1.setOnClickListener {

            if (namevalidation() && about_validaiton() && mobile_number_validation() && email_validation() && cityvalidation() && servicevalidation() && therapist_focus() && type_of_doctor()){
                val intent = Intent(this , Added_Therapist::class.java)
                startActivity(intent)
                overridePendingTransition(0,0)}
        }


    }
    // Name Validations
    private fun namevalidation() : Boolean {
        val name = addTherapistBinding.firstName1.text.toString().trim()
        val about = addTherapistBinding.about1.text.toString().trim()
        val mobile_number = addTherapistBinding.mobileNumber1.text.toString().trim()

        if (name.isEmpty()){
            addTherapistBinding.firstName1.setError("Name Field Cannot be Empty")
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