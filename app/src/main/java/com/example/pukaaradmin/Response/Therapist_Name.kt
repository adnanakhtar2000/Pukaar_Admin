package com.example.pukaaradmin.Response

data class Therapist_Name(val success : Success)

data class Success (

    val id : Int,
    val about : String,
    val city : String,
    val therapist_focus : String,
    val type_of_doctor : String,
    val introduction : String,
    val education : String,
    val user : User_Therapist
)

data class User_Therapist (

    val id : Int,
    val first_name : String,
    val last_name : String,
    val mobile_number : String,
    val email : String,
    val created_at : String,
    val updated_at : String
)

