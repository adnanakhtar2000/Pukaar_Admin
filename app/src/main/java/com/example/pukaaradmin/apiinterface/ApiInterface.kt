package com.example.pukaaradmin.apiinterface

import com.example.pukaaradmin.ModelClasses.GetMessage
import com.example.pukaaradmin.Response.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @FormUrlEncoded
    @POST("login")
    fun getLoginResponse(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("comment")
    fun createComment(
        @Header("Authorization") authorization: String?,
        @Field("comment") comment: String?,
        @Field("post_id") postId: Int
    ): Call<String?>?



    @FormUrlEncoded
    @POST("register")
    fun getRegisterResponse(
        @Field("first_name") fName: String,
        @Field("last_name") LName: String,
        @Field("email") email: String,
        @Field("mobile_number") mobile: String,
        @Field("password") password: String,
        @Field("c_password") Cpassword: String,
        @Field("role") role: String,
        @Field("about") about: String,
        @Field("city") city: String,
        @Field("service_therapist_provider") provider: String,
        @Field("therapist_focus") focus: String,
        @Field("type_of_doctor") doctor: String,
        @Field("status_id") status: Int,
        @Field("introduction") introduction: String,
        @Field("education") education: String,
    ): Call<SignUpResponse>

    @FormUrlEncoded
    @POST("user")
    fun getUserTherapistResponse(
        @Header("Authorization") header: String,
        @Field("role") role: String,
        @Field("status") status: String,
        @Field("type") type: String
    ): Call<TherapistListResponse>
    @FormUrlEncoded
    @POST("user")
    fun getUserunavailbleTherapistResponse(
        @Header("Authorization") header: String,
        @Field("role") role: String,
        @Field("status") status: String,

    ): Call<TherapistListResponse>

    fun getRegisterResponse2(@Field("first_name") fName: String,@Field("last_name") LName: String,@Field("email") email: String,
                            @Field("mobile_number") mobile: String,
                         @Field("password") password: String,
                         @Field("c_password") Cpassword: String,
                         @Field("role") role: String,
                         @Field("about") about: String,
                         @Field("city") city: String,
                         @Field("service_therapist_provider") provider: String,
                         @Field("therapist_focus") focus: String,
                         @Field("type_of_doctor") doctor: String,
                         @Field("status_id") status: Int) : Call<SignUpResponse>
    @FormUrlEncoded
    @POST("user")
    fun getUserTherapistResponse(@Header("Authorization") header: String,@Field("role") role: String,@Field("type") type: String) : Call<TherapistListResponse>


    @FormUrlEncoded
    @POST("package")
    fun createSpecialOffer(
        @Header("Authorization") header: String,
        @Field("number_of_sessions") number: Int,
        @Field("price") price: String
    ): Call<String>

    @FormUrlEncoded

    @POST("bank")
    fun createBankDetail(
        @Header("Authorization") header: String,
        @Field("bank_name") name: String,
        @Field("branch_name") branchName: String,
        @Field("account_number") accountNumber: String,
        @Field("account_title") accountTitle: String,
        @Field("iban") iban: String
    ): Call<String>

    @FormUrlEncoded
    @POST("admin/session")
    fun getUserSessionDetails(
        @Header("Authorization") header: String,
        @Field("status") name: String
    ): Call<UserSessionResponse>

    @FormUrlEncoded
    @POST("admin/session")
    fun getUserDonationSessionDetails(
        @Header("Authorization") header: String,
        @Field("status") name: String,
        @Field("donation") donation: String
    ): Call<UserSessionResponse>


    @FormUrlEncoded
    @POST("admin/session/update")
    fun getUserSessionUpdate(
        @Header("Authorization") header: String,
        @Field("status") status: String,
        @Field("session_id") session_id: String
    ): Call<String>
    @FormUrlEncoded
    @GET("users/{id}/edit")
    fun getConnectedUserResponse(@Header("Authorization") header: String, @Field("id") id: String): Call<ConnectUserResponse>


    @FormUrlEncoded
    @POST("send-message")
    fun sendMessage(
        @Header("Authorization") authorization: String?,
        @Field("reciever_id") receiverId: String?,
        @Field("message") message: String?
    ): Call<MessageResponse?>?

    @FormUrlEncoded
    @POST("get-message")
    fun getmessage(
        @Header("Authorization") authorization: String?, @Field("reciever_id") receiverId: Int?
    ): Call<GetMessage>?

    @GET("forum")
    fun getForumList(@Header("Authorization") authorization: String?): Call<ForumResponse?>?

    @Multipart
    @POST("post")
    fun createPost(
        @Header("Authorization") authorization: String?,
        @Part("content") content: RequestBody?,
        @Part("picture\"; filename=\"pp.png") file: RequestBody?
    ): Call<String?>?



    @GET("get-notifications/2")
    fun getNotification(@Header("Authorization") authorization: String?): Call<ArrayList<NotificationResponse?>?>?

    @FormUrlEncoded
    @POST("admin/update/therapist")
    fun assignedTherapist(
        @Header("Authorization") authorization: String?, @Field("client_profile_id") client_id: Int?, @Field("therapist_profile_id") therapist_id: Int?
    ): Call<String>?


}

