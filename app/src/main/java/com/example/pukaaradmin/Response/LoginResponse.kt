package com.example.pukaaradmin.Response

import android.provider.ContactsContract

data class LoginResponse(var data : Data)
data class Data(var token: String, var user_id: String, var first_name: String, var last_name: String, var email : String, var role: Array<String>)


