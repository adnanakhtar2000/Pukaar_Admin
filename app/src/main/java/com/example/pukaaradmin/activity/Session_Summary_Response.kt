package com.example.pukaaradmin.activity

data class Session_Summary_Response(var data : ArrayList<Data_Session>)

data class Data_Session (

    val id : Int,
    val client_id : String,
    val therapist_id : String,
    val session_taken : String,
    val session_taken_time : String,
    val client : Client_Sessions,
    val therapist : Therapist
)

data class Client_Sessions (

    val id : Int,
    val first_name : String,
    val last_name : String,
    val mobile_number : String,
    val email : String,
    val created_at : String,
    val updated_at : String
)

data class Therapist (

    val id : Int,
    val first_name : String,
    val last_name : String,
    val mobile_number : String,
    val email : String,
    val created_at : String,
    val updated_at : String
)
