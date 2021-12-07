package com.example.pukaaradmin.apiinterface

import com.example.pukaaradmin.Response.LoginResponse
import retrofit2.Call
import retrofit2.http.POST

interface ApiInterface {
    @POST("login")
    fun getLoginResponse() : Call<LoginResponse>
}