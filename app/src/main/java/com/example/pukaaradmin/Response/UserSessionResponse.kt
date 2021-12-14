package com.example.pukaaradmin.Response

data class UserSessionResponse(var current_page : Int,var data : ArrayList<UserData>,var first_page_url : String,var from : Int,var last_page : Int,var last_page_url : String,var next_page_url : String,var path : String,var per_page : Int
,var prev_page_url : String,var to : Int,var total : Int)
data class UserData(var id: Int, var picture: String, var status: String, var number_of_sessions: Int, var cost : Int, var user: UserDetailData)
data class UserDetailData(var id: Int, var first_name: String, var last_name: String, var mobile_number: String, var email : String, var assigned_client: String, var assigned_therapist: String, var created_at: String, var updated_at: String)



