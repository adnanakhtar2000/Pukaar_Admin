package com.example.pukaaradmin.apiinterface

import com.example.pukaaradmin.Response.LoginResponse
import com.example.pukaaradmin.Response.SignUpResponse
import com.example.pukaaradmin.Response.TherapistListResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("login")
    fun getLoginResponse(@Field("email") email: String,
                         @Field("password") password: String) : Call<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    fun getRegisterResponse(@Field("first_name") fName: String,@Field("last_name") LName: String,@Field("email") email: String,
                            @Field("mobile_number") mobile: String,
                         @Field("password") password: String,
                         @Field("c_password") Cpassword: String,
                         @Field("role") role: String,
                         @Field("about") about: String,
                         @Field("city") city: String,
                         @Field("service_therapist_provider") provider: String,
                         @Field("therapist_focus") focus: String,
                         @Field("type_of_doctor") doctor: String) : Call<SignUpResponse>
    @FormUrlEncoded
    @POST("user")
    fun getUserTherapistResponse(@Header("Authorization") header: String,@Field("role") role: String,@Field("type") type: String) : Call<TherapistListResponse>

    @FormUrlEncoded
    @POST("package")
    fun createSpecialOffer(@Header("Authorization") header: String,@Field("number_of_sessions") number: Int,@Field("price") price: String) : Call<String>
}