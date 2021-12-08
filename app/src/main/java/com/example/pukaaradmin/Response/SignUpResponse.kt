package com.example.pukaaradmin.Response

data class SignUpResponse(var data : SignUpData)
data class SignUpData(var token: String, var user_id: String, var first_name: String, var last_name: String, var email : String, var role: String)



